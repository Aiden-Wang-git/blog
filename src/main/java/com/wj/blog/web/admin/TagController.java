package com.wj.blog.web.admin;

import com.wj.blog.po.Tag;
import com.wj.blog.po.Type;
import com.wj.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.print.PageableDoc;

import javax.validation.Valid;

/**
 * @description:
 * @author: WangJun
 * @time: 2020/10/27 14:51
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    /*
    * @Description 查看标签列表
    * @Author  WangJun
    * @Date   2020/10/27 15:09
    * @Params [pageable, model]
    * @Return java.lang.String
    * @Exception
    */
    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC)
                               Pageable pageable, Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    /*
    * @Description 添加标签的接口
    * @Author  WangJun
    * @Date   2020/10/27 15:09
    * @Params [model]
    * @Return java.lang.String
    * @Exception
    */
    @RequestMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }
    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){
        if (tagService.getTagByName(tag.getName())!=null){
            result.rejectValue("name","nameError","不能添加重复标签");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Tag t = tagService.saveTag(tag);
        if (t!=null){
            attributes.addFlashAttribute("message","标签添加成功");
        }else {
            attributes.addFlashAttribute("message","标签添加失败");
        }
        return "redirect:/admin/tags";
    }

    /*
    * @Description 删除标签
    * @Author  WangJun
    * @Date   2020/10/27 15:43
    * @Params
    * @Return
    * @Exception
    */
    @RequestMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","标签删除成功");
        return "redirect:/admin/tags";
    }

    /*
    * @Description 修改标签
    * @Author  WangJun
    * @Date   2020/10/27 15:10
    * @Params
    * @Return
    * @Exception
    */
    @RequestMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags-input";
    }
    @RequestMapping("/tags/{id}")
    public String editPost(@Valid Tag tag,BindingResult result,@PathVariable Long id,RedirectAttributes attributes){
        if (tagService.getTagByName(tag.getName())!=null){
            result.rejectValue("name","nameError","不能添加重复标签");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Tag t = tagService.updateTag(id,tag);
        if (t!=null){
            attributes.addFlashAttribute("message","标签修改成功");
        }else {
            attributes.addFlashAttribute("message","标签修改失败");
        }
        return "redirect:/admin/tags";
    }
}
