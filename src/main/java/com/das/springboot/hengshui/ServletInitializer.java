package com.das.springboot.hengshui;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 	类描述：TODO(web容器中进行部署)
 *	 项目名称：rseqcsystem
 * 	包名：org.rseqcsystem
 * 	类名称：ServletInitializer
 * 	创建人：@author qhb
 * 	创建时间：2020年5月8日 下午3:10:18
 * 	修改人：@author
 * 	修改时间：2020年5月8日 下午3:10:18
 * 	修改备注：
 * @version
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HengshuiApplication.class);
	}
	
}
