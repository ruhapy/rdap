/*
 * Copyright (c) 2012 - 2015, Internet Corporation for Assigned Names and
 * Numbers (ICANN) and China Internet Network Information Center (CNNIC)
 * 
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  
 * * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * * Neither the name of the ICANN, CNNIC nor the names of its contributors may
 *  be used to endorse or promote products derived from this software without
 *  specific prior written permission.
 *  
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL ICANN OR CNNIC BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package cn.cnnic.rdap.common.util;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import cn.cnnic.rdap.BaseTest;

/**
 * Test for StringUtil
 * 
 * @author jiashuo
 * 
 */
@SuppressWarnings("rawtypes")
public class StringUtilTest extends BaseTest {

    /**
     * test encoded URL.
     * 
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testEncodedURL() throws UnsupportedEncodingException {
        String qEncode = URLEncoder.encode("中文。中国", "UTF-8");
        String expectURL = "http://cwhois.cnnic.cn/whois?inputfield=value&entity=domain&value="
                + qEncode;
        String encodedURL = expectURL;
        String result = StringUtil.urlEncode(encodedURL);
        assertEquals(expectURL, result);
    }

    /**
     * test decoded URL.
     * 
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testDecodedURL() throws UnsupportedEncodingException {
        String qEncode = URLEncoder.encode("中文。中国", "UTF-8");
        String expectURL = "http://cwhois.cnnic.cn/whois?inputfield=value&entity=domain&value="
                + qEncode;
        String decodedURL = "http://cwhois.cnnic.cn/whois?inputfield=value&entity=domain&value=中文。中国";
        String result = StringUtil.urlEncode(decodedURL);
        assertEquals(expectURL, result);
    }

}
