package neo.study.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import neo.study.web.model.Greeting;

@RestController
public class RestfulController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/list")
	public Map<String, Object> getMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zzy","是我大儿子。");
		map.put("zzt", "是我小儿子。");
		return map;
	}
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
