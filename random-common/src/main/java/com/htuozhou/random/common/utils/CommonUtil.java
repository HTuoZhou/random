package com.htuozhou.random.common.utils;

import com.htuozhou.random.common.constant.EasyExcelConstant;
import com.htuozhou.random.common.dict.BaseDict;
import com.htuozhou.random.common.service.I18nService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author hanzai
 * @date 2023/2/3
 */
public class CommonUtil {

    public static void setResponse(HttpServletResponse response, String fileName) {
        response.setContentType(EasyExcelConstant.EXCEL_CONTENT_TYPE);
        // 下载EXCEL
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + EasyExcelConstant.EXCEL_DOWNLOAD_FORMAT);
        response.setCharacterEncoding(EasyExcelConstant.CHARSET_UTF);
    }

    /***
     * 获取国际化的值
     * @param dict
     * @param i18nService
     * @return
     */
    public static String getI18nMsg(BaseDict dict, I18nService i18nService) {
        return i18nService.getMessage(dict.getI18nKey(), dict.getDefaultValue());
    }

}
