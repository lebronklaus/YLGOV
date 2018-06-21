package com.lee.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class MyMultiPartRequest {
	
	static final Logger LOG = LoggerFactory.getLogger(MultiPartRequest.class);  
	         
	        // maps parameter name -> List of FileItem objects  
	       protected Map<String,List<FileItem>> files = new HashMap<String,List<FileItem>>();  
	      
	        // maps parameter name -> List of param values  
	        protected Map<String,List<String>> params = new HashMap<String,List<String>>();  
     
	      // any errors while processing this request  
	        protected List<String> errors = new ArrayList<String>();  
	          
	        protected long maxSize;  
	      
	        @Inject(StrutsConstants.STRUTS_MULTIPART_MAXSIZE)  
	        public void setMaxSize(String maxSize) {  
	            this.maxSize = Long.parseLong(maxSize);  
	        }  
	      
	        /**  
	         * Creates a new request wrapper to handle multi-part data using methods adapted from Jason Pell's  
	50.         * multipart classes (see class description).  
	51.         *  
	52.         * @param saveDir        the directory to save off the file  
	53.         * @param request the request containing the multipart  
	54.         * @throws java.io.IOException  is thrown if encoding fails.  
	55.         */  
	       public void parse(HttpServletRequest request, String saveDir) throws IOException {  
	           try {  
	               processUpload(request, saveDir);  
	            } catch (FileUploadException e) {  
	               LOG.warn("Unable to parse request", e);  
	              errors.add(e.getMessage());  
	           }  
	      }  
	     
	        private void processUpload(HttpServletRequest request, String saveDir) throws FileUploadException, UnsupportedEncodingException {  
	            for (FileItem item : parseRequest(request, saveDir)) {  
	                if (LOG.isDebugEnabled()) {  
	                   LOG.debug("Found item " + item.getFieldName());  
	                }  
	                if (item.isFormField()) {  
	                    processNormalFormField(item, request.getCharacterEncoding());  
	                } else {  
	                    processFileField(item);  
	                }  
	            }  
	        }  
	      
	        private void processFileField(FileItem item) {  
	           
	      
	            // Skip file uploads that don't have a file name - meaning that no file was selected.  
	            if (item.getName() == null || item.getName().trim().length() < 1) {  
	               
	                return;  
	           }  
      
	            List<FileItem> values;  
	            if (files.get(item.getFieldName()) != null) {  
	               values = files.get(item.getFieldName());  
	            } else {  
	              values = new ArrayList<FileItem>();  
	            }  
	      
	            values.add(item);  
	            files.put(item.getFieldName(), values);  
       }  
	    
	        private void processNormalFormField(FileItem item, String charset) throws UnsupportedEncodingException {  
	            LOG.debug("Item is a normal form field");  
	            List<String> values;  
	           if (params.get(item.getFieldName()) != null) {  
	                values = params.get(item.getFieldName());  
	           } else {  
	               values = new ArrayList<String>();  
	            }  
	     
           // note: see http://jira.opensymphony.com/browse/WW-633  
	           // basically, in some cases the charset may be null, so  
	          // we're just going to try to "other" method (no idea if this  
	           // will work)  
           if (charset != null) {  
	               values.add(item.getString(charset));  
	           } else {  
	                values.add(item.getString());  
	           }  
	            params.put(item.getFieldName(), values);  
	        }  
	        private RequestContext createRequestContext(final HttpServletRequest req) {
		        return new RequestContext() {
		            public String getCharacterEncoding() {
		                return req.getCharacterEncoding();
		            }

		            public String getContentType() {
		                return req.getContentType();
		            }

		            public int getContentLength() {
		                return req.getContentLength();
		            }

		            public InputStream getInputStream() throws IOException {
		                InputStream in = req.getInputStream();
		                if (in == null) {
		                    throw new IOException("Missing content in the request");
		                }
		                return req.getInputStream();
		            }
		        };
		    }
		    
	        private List<FileItem> parseRequest(HttpServletRequest servletRequest, String saveDir) throws FileUploadException {  
	            DiskFileItemFactory fac = createDiskFileItemFactory(saveDir);  
	            ServletFileUpload upload = new ServletFileUpload(fac);  
	           upload.setSizeMax(maxSize);  
	            /*�Լ��½�������*/  
	            FileUploadListener progressListener = new FileUploadListener(servletRequest);  
	            upload.setProgressListener(progressListener);//�����Լ��ļ�����  
	              
	           return upload.parseRequest(createRequestContext(servletRequest));  
	        }  
	     
	        private DiskFileItemFactory createDiskFileItemFactory(String saveDir) {  
	            DiskFileItemFactory fac = new DiskFileItemFactory();  
	            // Make sure that the data is written to file  
            fac.setSizeThreshold(0);  
	            if (saveDir != null) {  
	                fac.setRepository(new File(saveDir));  
	            }  
	            return fac;  
	        }  
	      
	        /* (non-Javadoc)  
	        * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getFileParameterNames()  
	         */  
	        public Enumeration<String> getFileParameterNames() {  
	            return Collections.enumeration(files.keySet());  
	        }  
	     
	       /* (non-Javadoc)  
	148.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getContentType(java.lang.String)  
	149.         */  
	       public String[] getContentType(String fieldName) {  
	           List<FileItem> items = files.get(fieldName);  
	     
	            if (items == null) {  
	                return null;  
	            }  
	     
	            List<String> contentTypes = new ArrayList<String>(items.size());  
	            for (FileItem fileItem : items) {  
	                contentTypes.add(fileItem.getContentType());  
	            }  
	     
	            return contentTypes.toArray(new String[contentTypes.size()]);  
	       }  
	      
	       /* (non-Javadoc)  
	166.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getFile(java.lang.String)  
	167.         */  
	        public File[] getFile(String fieldName) {  
	           List<FileItem> items = files.get(fieldName);  
	      
	          if (items == null) {  
	              return null;  
	            }  
	     
	            List<File> fileList = new ArrayList<File>(items.size());  
	            for (FileItem fileItem : items) {  
	              File storeLocation = ((DiskFileItem) fileItem).getStoreLocation();  
	                if(fileItem.isInMemory() && storeLocation!=null && !storeLocation.exists()) {  
	                    try {  
	                        storeLocation.createNewFile();  
	                    } catch (IOException e) {  
	                        if(LOG.isErrorEnabled()){  
	                          LOG.error("Cannot write uploaded empty file to disk: " + storeLocation.getAbsolutePath(),e);  
	                       }  
	                    }  
	               }  
	               fileList.add(storeLocation);  
	            }  
	      
	           return fileList.toArray(new File[fileList.size()]);  
	       }  
	      
	        /* (non-Javadoc)  
	194.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getFileNames(java.lang.String)  
	195.         */  
	       public String[] getFileNames(String fieldName) {  
	            List<FileItem> items = files.get(fieldName);  
	      
	           if (items == null) {  
	                return null;  
	           }  
	    
	            List<String> fileNames = new ArrayList<String>(items.size());  
	            for (FileItem fileItem : items) {  
	               fileNames.add(getCanonicalName(fileItem.getName()));  
	          }  
	     
	            return fileNames.toArray(new String[fileNames.size()]);  
	        }  
	       
	       
	       private String getCanonicalName(String filename) {
	           int forwardSlash = filename.lastIndexOf("/");
	           int backwardSlash = filename.lastIndexOf("\\");
	           if (forwardSlash != -1 && forwardSlash > backwardSlash) {
	               filename = filename.substring(forwardSlash + 1, filename.length());
	           } else if (backwardSlash != -1 && backwardSlash >= forwardSlash) {
	               filename = filename.substring(backwardSlash + 1, filename.length());
	           }
	           return filename;
	       }
	       /* (non-Javadoc)  
	212.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getFilesystemName(java.lang.String)  
	213.         */  
	        public String[] getFilesystemName(String fieldName) {  
	            List<FileItem> items = files.get(fieldName);  
	      
	            if (items == null) {  
	                return null;  
	           }  
	      
	           List<String> fileNames = new ArrayList<String>(items.size());  
	            for (FileItem fileItem : items) {  
	                fileNames.add(((DiskFileItem) fileItem).getStoreLocation().getName());  
	          }  
	     
	           return fileNames.toArray(new String[fileNames.size()]);  
       }  
	     
        /* (non-Javadoc)  
	230.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getParameter(java.lang.String)  
	231.         */  
	        public String getParameter(String name) {  
	            List<String> v = params.get(name);  
	            if (v != null && v.size() > 0) {  
	                return v.get(0);  
	           }  
	      
	            return null;  
	        }  
	      
	       /* (non-Javadoc)  
	242.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getParameterNames()  
	243.         */  
	        public Enumeration<String> getParameterNames() {  
	           return Collections.enumeration(params.keySet());  
	        }  
	      
	        /* (non-Javadoc)  
	249.         * @see org.apache.struts2.dispatcher.multipart.MultiPartRequest#getParameterValues(java.lang.String)  
	250.         */  
	       public String[] getParameterValues(String name) {  
	            List<String> v = params.get(name);  
	            if (v != null && v.size() > 0) {  
	                return v.toArray(new String[v.size()]);  
	          }  
	     
	            return null;  
       }  
	     
	        }
	
 