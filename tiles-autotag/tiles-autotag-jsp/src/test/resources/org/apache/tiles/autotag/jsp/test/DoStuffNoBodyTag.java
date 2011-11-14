package org.apache.tiles.autotag.jsp.test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.tiles.autotag.core.runtime.AutotagRuntime;
import org.apache.tiles.request.Request;

/**
 * Documentation of the DoStuffNoBody class.
 */
public class DoStuffNoBodyTag extends SimpleTagSupport {

    /**
     * The template model.
     */
    private org.apache.tiles.autotag.template.DoStuffNoBodyTemplate model = new org.apache.tiles.autotag.template.DoStuffNoBodyTemplate();

    /**
     * Parameter one.
     */
    private java.lang.Double one;

    /**
     * Parameter two.
     */
    private float two;

    /**
     * Parameter three.
     */
    private java.util.Date three;

    /**
     * Getter for one property.
     *
     * @return
     * Parameter one.
     */
    public java.lang.Double getOne() {
        return one;
    }

    /**
     * Setter for one property.
     *
     * @param one
     * Parameter one.
     */
    public void setOne(java.lang.Double one) {
        this.one = one;
    }

    /**
     * Getter for two property.
     *
     * @return
     * Parameter two.
     */
    public float getTwo() {
        return two;
    }

    /**
     * Setter for two property.
     *
     * @param two
     * Parameter two.
     */
    public void setTwo(float two) {
        this.two = two;
    }

    /**
     * Getter for three property.
     *
     * @return
     * Parameter three.
     */
    public java.util.Date getThree() {
        return three;
    }

    /**
     * Setter for three property.
     *
     * @param three
     * Parameter three.
     */
    public void setThree(java.util.Date three) {
        this.three = three;
    }

    /** {@inheritDoc} */
    @Override
    public void doTag() throws JspException, IOException {
        AutotagRuntime runtime = new org.apache.tiles.autotag.jsp.test.Runtime();
        if (runtime instanceof SimpleTagSupport) {
            SimpleTagSupport tag = (SimpleTagSupport) runtime;
            tag.setJspContext(getJspContext());
            tag.setJspBody(getJspBody());
            tag.setParent(getParent());
            tag.doTag();
        }
        Request request = runtime.createRequest();        
        model.execute(
            one,
            two,
            three,
            request
        );
    }
}
