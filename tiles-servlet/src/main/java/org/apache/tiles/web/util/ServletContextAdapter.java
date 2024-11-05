/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tiles.web.util;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;

/**
 * Adapts a servlet config and a servlet context to become a unique servlet
 * context.
 *
 * @version $Rev$ $Date$
 */
@SuppressWarnings("deprecation")
public class ServletContextAdapter implements ServletContext {

    /**
     * The root context to use.
     */
    private ServletContext rootContext;

    /**
     * The union of init parameters of {@link ServletConfig} and
     * {@link ServletContext}.
     */
    private Hashtable<String, String> initParameters;


    /**
     * Constructor.
     *
     * @param config The servlet configuration object.
     */
    @SuppressWarnings("unchecked")
    public ServletContextAdapter(ServletConfig config) {
        this.rootContext = config.getServletContext();
        initParameters = new Hashtable<String, String>();
        Enumeration<String> enumeration = rootContext
                .getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramName = enumeration.nextElement();
            initParameters.put(paramName, rootContext
                    .getInitParameter(paramName));
        }
        enumeration = config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramName = enumeration.nextElement();
            initParameters.put(paramName, config.getInitParameter(paramName));
        }
    }

    /** {@inheritDoc} */
    public ServletContext getContext(String string) {
        return rootContext.getContext(string);
    }

    /** {@inheritDoc} */
    public int getMajorVersion() {
        return rootContext.getMajorVersion();
    }

    /** {@inheritDoc} */
    public int getMinorVersion() {
        return rootContext.getMinorVersion();
    }

    @Override
    public int getEffectiveMajorVersion() {
        return 0;
    }

    @Override
    public int getEffectiveMinorVersion() {
        return 0;
    }

    /** {@inheritDoc} */
    public String getMimeType(String string) {
        return rootContext.getMimeType(string);
    }

    /** {@inheritDoc} */
    @SuppressWarnings({ "rawtypes" })
    public Set getResourcePaths(String string) {
        return rootContext.getResourcePaths(string);
    }

    /** {@inheritDoc} */
    public URL getResource(String string) throws MalformedURLException {
        return rootContext.getResource(string);
    }

    /** {@inheritDoc} */
    public InputStream getResourceAsStream(String string) {
        return rootContext.getResourceAsStream(string);
    }

    /** {@inheritDoc} */
    public RequestDispatcher getRequestDispatcher(String string) {
        return rootContext.getRequestDispatcher(string);
    }

    /** {@inheritDoc} */
    public RequestDispatcher getNamedDispatcher(String string) {
        return rootContext.getNamedDispatcher(string);
    }

    /** {@inheritDoc} */
    public Servlet getServlet(String string) throws ServletException {
        return rootContext.getServlet(string);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("rawtypes")
    public Enumeration getServlets() {
        return rootContext.getServlets();  //To change body of implemented methods use File | Settings | File Templates.
    }

    /** {@inheritDoc} */
    @SuppressWarnings("rawtypes")
    public Enumeration getServletNames() {
        return rootContext.getServletNames();
    }

    /** {@inheritDoc} */
    public void log(String string) {
        rootContext.log(string);
    }

    /** {@inheritDoc} */
    public void log(Exception exception, String string) {
        rootContext.log(exception, string);
    }

    /** {@inheritDoc} */
    public void log(String string, Throwable throwable) {
        rootContext.log(string, throwable);
    }

    /** {@inheritDoc} */
    public String getRealPath(String string) {
        return rootContext.getRealPath(string);
    }

    /** {@inheritDoc} */
    public String getServerInfo() {
        return rootContext.getServerInfo();
    }

    /** {@inheritDoc} */
    public String getInitParameter(String string) {
        return initParameters.get(string);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("rawtypes")
    public Enumeration getInitParameterNames() {
        return initParameters.keys();
    }

    @Override
    public boolean setInitParameter(String name, String value) {
        return false;
    }

    /** {@inheritDoc} */
    public Object getAttribute(String string) {
        return rootContext.getAttribute(string);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("rawtypes")
    public Enumeration getAttributeNames() {
        return rootContext.getAttributeNames();
    }

    /** {@inheritDoc} */
    public void setAttribute(String string, Object object) {
        rootContext.setAttribute(string, object);
    }

    /** {@inheritDoc} */
    public void removeAttribute(String string) {
        rootContext.removeAttribute(string);
    }

    /** {@inheritDoc} */
    public String getServletContextName() {
        return rootContext.getServletContextName();
    }

    @Override
    public ServletRegistration.Dynamic addServlet(String servletName, String className) {
        return null;
    }

    @Override
    public ServletRegistration.Dynamic addServlet(String servletName, Servlet servlet) {
        return null;
    }

    @Override
    public ServletRegistration.Dynamic addServlet(String servletName, Class<? extends Servlet> servletClass) {
        return null;
    }

    @Override
    public ServletRegistration.Dynamic addJspFile(String servletName, String jspFile) {
        return null;
    }

    @Override
    public <T extends Servlet> T createServlet(Class<T> clazz) throws ServletException {
        return null;
    }

    @Override
    public ServletRegistration getServletRegistration(String servletName) {
        return null;
    }

    @Override
    public Map<String, ? extends ServletRegistration> getServletRegistrations() {
        return null;
    }

    @Override
    public FilterRegistration.Dynamic addFilter(String filterName, String className) {
        return null;
    }

    @Override
    public FilterRegistration.Dynamic addFilter(String filterName, Filter filter) {
        return null;
    }

    @Override
    public FilterRegistration.Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
        return null;
    }

    @Override
    public <T extends Filter> T createFilter(Class<T> clazz) throws ServletException {
        return null;
    }

    @Override
    public FilterRegistration getFilterRegistration(String filterName) {
        return null;
    }

    @Override
    public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
        return null;
    }

    @Override
    public SessionCookieConfig getSessionCookieConfig() {
        return null;
    }

    @Override
    public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {

    }

    @Override
    public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
        return null;
    }

    @Override
    public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
        return null;
    }

    @Override
    public void addListener(String className) {

    }

    @Override
    public <T extends EventListener> void addListener(T t) {

    }

    @Override
    public void addListener(Class<? extends EventListener> listenerClass) {

    }

    @Override
    public <T extends EventListener> T createListener(Class<T> clazz) throws ServletException {
        return null;
    }

    @Override
    public JspConfigDescriptor getJspConfigDescriptor() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void declareRoles(String... roleNames) {

    }

    @Override
    public String getVirtualServerName() {
        return null;
    }

    @Override
    public int getSessionTimeout() {
        return 0;
    }

    @Override
    public void setSessionTimeout(int sessionTimeout) {

    }

    @Override
    public String getRequestCharacterEncoding() {
        return null;
    }

    @Override
    public void setRequestCharacterEncoding(String encoding) {

    }

    @Override
    public String getResponseCharacterEncoding() {
        return null;
    }

    @Override
    public void setResponseCharacterEncoding(String encoding) {

    }

    /** {@inheritDoc} */
    public String getContextPath() {
        return rootContext.getContextPath();
    }
}
