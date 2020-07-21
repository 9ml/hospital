package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Ydscxb;
import com.litbo.hospitalzj.checklist.domain.YdscxbTemplate;

import java.util.List;

public interface YdscxbService {
    void updateYdscxbTemplate(YdscxbTemplate ydscxbTemplate);

    void insert(YdscxbTemplate ydscxbTemplate);

    void save(Ydscxb ydscxb);

    void updateYdscxb(Ydscxb ydscxb);

    Ydscxb findByEqIdandJcyqIdLast1(String eqId, String jcyqId);

    List<Ydscxb> findByEqIdandJcyqId(String eqId, String jcyqId);

    List<Ydscxb> findAll();

    Ydscxb findByYdId(Integer ydId);

    void updateShrJcjy(Integer ydId, String shrJcjl, String auditor);

    Ydscxb find();

    Ydscxb findYdscxb(String eqId);

    YdscxbTemplate findTemplate();
}
