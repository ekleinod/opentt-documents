
package de.edgesoft.opentt.documents.issues.model.additional;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.edgesoft.opentt.documents.issues.model.RulesType;


/**
 * Adapter for using include on rules.
 * 
 * This code was found (and adapted) on
 * http://stackoverflow.com/questions/14207421/jaxb-export-to-modular-xml-files-with-xiinclude
 * 
 * ## Legal stuff
 * 
 * Copyright 2014 Ekkart Kleinod <ekleinod@edgesoft.de>
 * 
 * This file is part of OpenTT-Documents.
 * 
 * OpenTT-Documents is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OpenTT-Documents is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OpenTT-Documents.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Ekkart Kleinod
 * @version 0.1
 * @since 0.1
 */
public class IncludeRulesAdapter extends XmlAdapter<IncludeRulesAdapter.Include, RulesType> {

	private JAXBContext jc;
    private String href = "fruit.xml";

    public IncludeRulesAdapter() {
        try {
            jc = JAXBContext.newInstance(RulesType.class);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static class Include {

        @XmlAttribute
        public String href;

        @XmlElement(namespace="http://www.w3.org/2001/XInclude")
        public Fallback fallback;

    }

    public static class Fallback {

        @XmlElementRef
        public RulesType value;

    }

    @Override
    public Include marshal(RulesType fruit) throws Exception {
        File xml = new File(href);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(fruit, xml);

        Include include = new Include();
        include.href = href;
        include.fallback = new Fallback();
        include.fallback.value = new RulesType();
        return include;
    }

    @Override
    public RulesType unmarshal(Include include) throws Exception {
        File xml = new File(include.href);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        try {
            return (RulesType) unmarshaller.unmarshal(xml);
        } catch(Exception e) {
            return include.fallback.value;
        }
    }
    
}

/* EOF */