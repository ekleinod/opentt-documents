package de.edgesoft.opentt.documents.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.edgesoft.opentt.documents.IssuesToXML;

/**
 * Test class for {@link IssuesToXML}.
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
 * @version 0.2
 * @since 0.2
 */
@RunWith(Parameterized.class)
public class IssuesToXMLTest {
	
	/** Arguments for tests. */
	private String[] arrArguments = null;

	/** Results for tests. */
	private Object[] arrResults = null;

	/**
	 * Constructor, settings the arguments and results.
	 * 
	 * @param theTestName test name (for junit output only)
	 * @param theArguments test arguments
	 * @param theResults test results
	 */
	public IssuesToXMLTest(String theTestName, String[] theArguments, Object[] theResults) {
		arrArguments = Arrays.copyOf(theArguments, theArguments.length);
		arrResults = Arrays.copyOf(theResults, theResults.length);
	}

	/**
	 * Definition of arguments and results.
	 * 
	 * @return collection of arguments and results.
	 */
	@Parameters(name="Testcase ''{0}'', Index {index}")
	public static Collection<Object[]> arguments() {

		List<Object[]> lstArguments = new ArrayList<>();
		String[] arguments = null;
		Object[] results = null;
		String name = null;

		// successful conversion with xml schema
		name = "withschema";
		arguments = new String[]{
				"--input",
				"../../issues/issuedocument.xml",
				"--output",
				String.format("../../export/%s.xml", name),
				"--xsd",
				"../schema/issuedocument.xsd",
		};
		results = new Object[]{Boolean.TRUE};

		lstArguments.add(new Object[]{name, arguments, results});

		// successful conversion without xml schema
		name = "noschema";
		arguments = new String[]{
				"--input",
				"../../issues/issuedocument.xml",
				"--output",
				String.format("../../export/%s.xml", name),
		};
		results = new Object[]{Boolean.TRUE};

		lstArguments.add(new Object[]{name, arguments, results});

		return lstArguments;
	}
	
	/**
	 * Executes one test.
	 */
	@Test
	public void testConvertAlternative() {

		boolean bSuccess = IssuesToXML.executeOperation(arrArguments);

		Assert.assertEquals(arrResults[0], bSuccess);

	}

}

/* EOF */
