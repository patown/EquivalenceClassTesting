
package com.comb.dataset;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.comb.dataset.beans.ActionBean;
import com.comb.dataset.beans.ItemBean;


public class InputFileDigester {

    private Document doc;

    private List<ActionBean>  actionBeans = new ArrayList<ActionBean>();

    
    //private SolventDataSet workingSolventDataSet;
    public InputFileDigester(InputStream in) {
        SAXReader reader = new SAXReader();
        try {
            doc = reader.read(in);
            parseData();
        } catch (DocumentException e) {
        //    log.error("Error when attmeping to parse input file", e);
        }
    }



    public List<ActionBean> getActionBeans() {

        return actionBeans;
    }
    
    /**
     * @param  Element  <paramter> </paramter>
	 * @return ItemBean
     */   
    private ItemBean parseItems(Element element){
		List vECList = new ArrayList<>() ;
		List iECList = new ArrayList<>() ;
		ItemBean itemBean =null;
		Element elm = null;
	//	Element paraElement=null;
		String name=null;
		List<Element> itemElements;
		//get action name
		if (element != null) {
		//	paraElement =element.element("paramter");
			name = element.attributeValue("name");
			itemBean=new ItemBean(name);
		} else{
			return null;
		}
		itemElements=element.elements("item");//items
		Iterator<Element> iterator = null;
		iterator = itemElements.iterator();
		while (iterator != null && iterator.hasNext()) {//parsing the items
			elm = iterator.next();
			if(elm.attributeValue("type").equalsIgnoreCase("vec")){ //valid EC item
				vECList.add(elm.getTextTrim());
			}
			if(elm.attributeValue("type").equalsIgnoreCase("iec")){ //invalid EC item
				iECList.add(elm.getTextTrim());
			}
		}
		itemBean.setIECList(iECList).setVECList(vECList);
		return itemBean;
    }
    
    
    /**
     * @param  Element  <action> </action>
	 * @return ActionBean
     */   
    private ActionBean parseAction(Element element){
		Element elm = null;
		String name=null;
		String comb=null;
		List<Element> itemElements;
		ActionBean actionBean;
		//get action name
		if (element != null) {
			name = element.attributeValue("name");
			comb = element.attributeValue("comb");
			actionBean=new ActionBean(name,comb);
		} else{
			return null;
		}
		itemElements=element.elements("parameter");//Parameters
		Iterator<Element> iterator = null;
		List<ItemBean> itemBeans= new ArrayList<ItemBean>();
		iterator = itemElements.iterator();
		
		while (iterator != null && iterator.hasNext()) {//parsing the items
			elm = iterator.next();
			itemBeans.add(parseItems(elm));
		}
		actionBean.setItemBeans(itemBeans);
		return actionBean;
    }
    /**
     * 
     * @return List<ActionBean>
     */
    public void parseData() {
        Element rootElement = this.doc.getRootElement();
		List<Element> actionsElements = rootElement.elements("action");
		for(Element element:actionsElements){
			ActionBean bean =parseAction(element); //one action 
			if(null !=bean){
				actionBeans.add(bean);
			}
		}
    }

}
