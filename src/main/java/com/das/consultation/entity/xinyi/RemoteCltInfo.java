package com.das.consultation.entity.xinyi;

import com.das.consultation.entity.RemoteCltInfoKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * created by jun on 2020/8/5
 * describe:远程会诊信息实体
 * version 1.0
 */
@Entity
@Table(name = "REMOTE_CONSULT_INFO")
@IdClass(RemoteCltInfoKey.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoteCltInfo {
    /**
     * 医疗机构代码#DE08.10.052.00#STD_ORG_CODE
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orgCode;
    /**
     * 病人ID#DE99.02.003.00#
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String patientId;
    /**
     * 申请科室ID
     */
    @Column
    private String applydeptid;
    /**
     * 申请医生ID
     */
    @Column
    private String applydocid;
    /**
     * 联系电话
     */
    @Column
    private String applydoctel;
    /**
     * 申请医院ID
     */
    @Column
    private String applyhospid;
    /**
     * 申请子科室ID
     */
    @Column
    private String applysubdeptid;
    /**
     * 申请时间
     */
    @Column
    private Date applytime;
    /**
     * 就诊类型
     */
    @Column
    private String applytype;
    /**
     * 会诊信息
     */
    @Column
    private String cmdata;
    /**
     * 是否加入过视频会议
     */
    @Column
    private String conferenceflag;
    /**
     * 会诊开始时间
     */
    @Column
    private Date consampm;
    /**
     * 是否公开会诊
     */
    @Column
    private String consattribute;

    /**
     * 会诊完成时间
     */
    @Column
    private String consend;
    /**
     * consultation_id
     */
    @Column
    private String consid;
    /**
     * 会诊方式
     */
    @Column
    private String consmode;
    /**
     * 会诊开始时间
     */
    @Column
    private Date consstart;
    /**
     * 会诊类型
     */
    @Column
    private String constype;
    /**
     * 会诊ID
     */
    @Column
    private String consultationid;
    /**
     * 创建人
     */
    @Column
    private String createoperator;
    /**
     * 创建时间
     */
    @Column
    private Date createtime;
    /**
     * 是否有效
     */
    @Column
    private String flag;
    /**
     * 备用金收费类型
     */
    @Column
    private String fundfeetype;
    /**
     * 挂起节点
     */
    @Column
    private String hangupnode;
    /**
     * 医院管理员姓名
     */
    @Column
    private String hospadminname;
    /**
     * 医院管理员电话
     */
    @Column
    private String hospadmintel;
    /**
     * 申请信息录入方式
     */
    @Column
    private String infotype;
    /**
     * 是否可以调配
     */
    @Column
    private String primallocate;
    /**
     * 点名类型
     */
    @Column
    private String primappointed;
    /**
     * 是否急诊
     */
    @Column
    private String primemergency;
    /**
     * 专家团队
     */
    @Column
    private String primexpertteam;
    /**
     * 随访类型
     */
    @Column
    private String primfollowup;
    /**
     * 会诊主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String primid;
    /**
     * 交互类型
     */
    @Column
    private String priminteractive;
    /**
     * MDT类型
     */
    @Column
    private String primmdt;
    /**
     * 会诊NO
     */
    @Column
    private String primno;
    /**
     * 预约类型
     */
    @Column
    private String primreservation;
    /**
     * 预约科室
     */
    @Column
    private String primreservedept;
    /**
     * 预约专科
     */
    @Column
    private String primreservespec;
    /**
     * 会诊状态
     */
    @Column
    private String primstatus;
    /**
     * 是否是回退会诊
     */
    @Column
    private String rejectflag;
    /**
     * 是否下载过报告
     */
    @Column
    private String reportflag;
    /**
     * 申请类型
     */
    @Column
    private String requesttype;
    /**
     * 申请科室名称
     */
    @Column
    private String selfdept;
    /**
     * 申请医生名称
     */
    @Column
    private String selfdoc;
    /**
     * 联系人电话
     */
    @Column
    private String selfdoctel;
    /**
     * 申请医院名称
     */
    @Column
    private String selfhosp;
    /**
     * 平台推送状态
     */
    @Column
    private String sendstatus;
    /**
     * 是否专家医联体
     */
    @Column
    private String uniteflag;
    /**
     * 最后更新人姓名
     */
    @Column
    private String modifier;
    /**
     * 最后更新时间
     */
    @Column
    private Date modifiedtime;
    /**
     * 上传时间
     */
    @Column
    private Date uploadtime;

}
