package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Ct;
import com.litbo.hospitalzj.checklist.domain.CtTemplate;
import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;

import java.util.List;

public interface CtService {
    CtTemplate findTemplate();

    void insert(CtTemplate ctTemplate);

    void updateCtTemplate(CtTemplate ctTemplate);

    void save(Ct ct);

    void updateCt(Ct ct);

    Ct findByCtid(Integer ctId);

    void updateShrJcjy(Integer ctId, String shrJcjl, String auditor);

    List<Ct> findByEqIdandJcyqId(String eqId, String jcyqId);

    List<Ct> findAll();

    Ct findByEqIdandJcyqIdLast1(String eqId, String jcyqId);

    Ct findCt(String eqId);

    Ct find();
}
