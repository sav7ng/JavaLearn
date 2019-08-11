package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Invoice;
import com.company.project.service.TreeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Class TreeController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.8.10 21:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("/Tree")
public class TreeController {

    @Autowired
    TreeService treeService;

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size,
                       @RequestParam(defaultValue = "0") Integer id) {
        PageHelper.startPage(page, size);
        //List<Invoice> list = treeService.getInvoiceById(id);
        //PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(treeService.getInvoiceById(id));
    }

}