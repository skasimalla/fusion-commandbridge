package com.as.cb.Util;

import java.util.Base64;

import org.apache.log4j.Logger;

public class Summarizer {
    final static Logger logger = Logger.getLogger(Summarizer.class);

    public static void main(String args[]) {
	String str = "Supporting more than 20,000 companies worldwide With close to 6,000 professionals in our tax, assurance and advisory network, we have the knowledge, skills, tools and resources to help contractors and related industry leaders focus on key issues affecting their businesses. Which issues affect your business the most? Are you concerned about managing risk? Do you face a talent gap? How are you dealing with financial issues, such as tax changes, overseas investments, commodity prices, and funding and working capital? Our Engineering and Construction practice provides advisory, tax and assurance insight about key issues and presents options for securing business or seizing new opportunities. We work closely with contractors, house builders and building products companies. You’ll also find us collaborating with professional and support services organizations, governments, and private and public sector companies. M&A activity in terms of value and volume slowed in Q1 2018 from Q4 2017. Increased concerns around potential trade conflicts appear to be weighing. One quarter does not make the year, and we believe underlying sector fundamentals remain positive over the long term. Adoption anxiety? We resolve the latest revenue implementation issues specific to the engineering and construction industry. The engineering and construction industry is marked by caution amid slowly recovering oil prices and mixed messages from the market. While the scope and sources of funding remain unspecified, prospects for a $1 trillion infrastructure stimulus plan are promising--and an industrials sector orientation is clear. Industrial insights blog Perspectives on critical business issues facing engineering and construction companies today Upskill your workforce to adopt a new digital mindset, enabling them to make what's next from within your organization. New technologies are changing the face of manufacturing — from 3D printing, robotics, the industrial Internet of Things, to autonomous vehicles.​ PwC US CEO Survey 2018 findings on outlooks for employment, M&A, important overseas markets. See how views on technology threats change since 2013. Michael Sobolewski Engineering and Construction leader, PwC US Tel: +1 (313) 394 3299 Email © 2017 - 2018 PwC. All rights reserved. PwC refers to the US member firm or one of its subsidiaries or affiliates, and may sometimes refer to the PwC network. Each member firm is a separate legal entity. Please see www.pwc.com/structure for further details.";
	System.out.println("Output:" + summarize(str, "20%", "python conf/summarizer.py"));
    }

    public static String summarize(String msg, String per, String scriptPath) {
	String res = "";
	String cmd;
	try {
	    String encodedMsg = Base64.getEncoder().encodeToString(msg.getBytes());
	    cmd = scriptPath + " " + per + " " + encodedMsg;
	    res = CommandUtil.extractFromCommand(cmd);
	} catch (Exception e1) {
	    e1.printStackTrace();
	}
	return res;
    }
}
