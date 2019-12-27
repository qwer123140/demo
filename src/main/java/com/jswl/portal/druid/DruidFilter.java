package com.jswl.portal.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName = "druidWebStatFilter", //
		urlPatterns = "/*", //
		initParams = { @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.bmp,*.png,*.css,/druid/*") })
public class DruidFilter extends WebStatFilter {

}