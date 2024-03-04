package com.example.demo.Model;

import lombok.Data;

@Data
public class RestInfo {
    //식당고유id
    private Integer crtfc_upso_mgt_sno;
    //업소번호
    private String upso_sno;

    private String upso_nm;
    private String cgg_code;
    private String cgg_code_nm;
    private String cob_code_nm;
    private String bizcnd_code_nm;
    private String owner_nm;
    private String crtfc_gbn;
    private String crtfc_gbn_nm;
    private String crtfc_chr_id;
    private String crtfc_ymd;
    private String use_yn;
    private String map_indict_yn;
    private String crtfc_class;
    private String y_dnts;
    private String x_dnts;
    private String tel_no;
    private String rdn_detail_addr;
    private String rdn_addr_code;
    private String rdn_code_nm;
    private String bizcnd_code;
    private String cob_code;
    private String crtfc_sno;
    private String crt_user;
    private String upd_time;
    private String food_menu;
    private String gnt_no;
    private String crtfc_yn;

}
