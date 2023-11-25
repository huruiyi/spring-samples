package com.ssm.maven.core.admin;

import com.ssm.maven.core.entity.Article;
import com.ssm.maven.core.entity.PageBean;
import com.ssm.maven.core.service.ArticleService;
import com.ssm.maven.core.util.DateUtil;
import com.ssm.maven.core.util.ResponseUtil;
import com.ssm.maven.core.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    private static final Logger log = Logger.getLogger(ArticleController.class);

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,
                       Article article, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (article != null) {
            map.put("articleTitle", StringUtil.formatLike(article.getArticleTitle()));
        }
        List<Article> articleList = articleService.findArticle(map);
        Long total = articleService.getTotalArticle(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(articleList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        log.info("request: article/list , map: " + map.toString());
        return null;
    }

    @RequestMapping("/save")
    public String save(Article article, HttpServletResponse response) throws Exception {
        int resultTotal;
        if (article.getId() == null) {
            article.setArticleCreateDate(DateUtil.getCurrentDateStr());
            resultTotal = articleService.addArticle(article);
        } else {
            resultTotal = articleService.updateArticle(article);
        }
        JSONObject result = new JSONObject();
        result.put("success", resultTotal > 0 ? true : false);
        ResponseUtil.write(response, result);
        log.info("request: article/save , " + article.toString());
        return null;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        String[] idsStr = ids.split(",");
        for (String s : idsStr) {
            articleService.deleteArticle(s);
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        log.info("request: article/delete , ids: " + ids);
        return null;
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
        Article article = articleService.findById(id);
        JSONObject jsonObject = JSONObject.fromObject(article);
        ResponseUtil.write(response, jsonObject);
        log.info("request: article/findById");
        return null;
    }
}
