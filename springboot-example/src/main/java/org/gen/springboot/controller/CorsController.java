package org.gen.springboot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * CORS(Cross-Origin Resource Sharing)是由W3C指定的一种跨域资源共享技术标注，其目的是为了解决前端的跨域请求。
 * 在J2EE开发中，最常见的前端跨域请求解决方案是JSONP，但JSONP只支持GET请求，而CORS则支持多种HTTP请求方法。
 * 以CORS中的GET请求为例，当浏览器发起请求时，请求头中携带了如下信息：
 * Host: server01:8081
 * Origin: http://localhost:8081
 * Referer: http://localhost:8081/
 * 假如服务器支持CORS，则服务器端给出的响应信息如下：
 * Access-Control-Allow-Origin: http://localhost:8081
 * Content-Length: 20
 * Content-Type: text/plain;charset=UTF-8
 * Date: Tue, 15 Jun 2021 12:03:00 GMT
 * 
 * 其中：
 * 1.Host 表示当前请求要被发送的目的地，说白了就是当前请求目标资源的host，仅包括域名和端口号，如server01:8081。在任何类型请求中，request都会包含此header信息。
 * 2.Origin 表示当前请求资源所在页面的协议和域名，如http://localhost:8081，特别注意：这个参数一般只存在于CORS跨域请求中，普通请求没有这个header！
 * 3.Referer 表示当前请求资源所在页面的完整路径：协议+域名+查询参数（注意不包含锚点信息），如http://localhost:8081/index.html?a=1&b=2，所有类型的请求都包含此header。
 * 响应头中有一个Access-Control-Allow-Origin字段，用来记录可以访问该资源的域，当浏览器收到这样的响应头信息之后，提取出Access-Control-Allow-Origin字段中的值，
 * 发现该值包含当前页面所在的域，就知道这个跨域是被允许的，因此就不再对前端的跨域请求进行限制。这个流程主要针对于GET、POST以及HEAD请求，并且没有自定义请求头。
 * 如果发起一个DELETE请求、PUT请求或者自定义请求头，流程就会稍微复杂一些。
 * 以DELETE请求为例，当前端发起一个DELETE请求时，这个请求的处理会经过两个步骤。
 * 第一步：发起一个OPTIONS请求。
 * 这个请求将向服务端询问是否具备该资源的DELETE权限，服务器会给浏览器一个响应，Allow头信息表示服务器支持的请求方法，这个请求相当于一个探测请求，当浏览器分析了请求头字段后，知道服务器支持本次请求，则进入第二步。
 * 第二步：发送DELETE请求。接下来浏览器就会发送一个跨域的DELETE请求，
 * 服务端给一个响应。
 * 至此一个跨域的DELETE请求完成。
 * 
 */
@RestController
@RequestMapping("/book")
public class CorsController {

	@PostMapping("/")
	@CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
	public String addBook(String name) {
		return "receive:" + name;
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
	public String deleteBookById(@PathVariable Long id) {
		return String.valueOf(id);
	}
}
