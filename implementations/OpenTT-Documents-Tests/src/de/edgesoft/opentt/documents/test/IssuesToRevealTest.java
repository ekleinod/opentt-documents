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

import de.edgesoft.opentt.documents.IssuesToReveal;

/**
 * Test class for {@link IssuesToReveal}.
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
public class IssuesToRevealTest {
	
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
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public IssuesToRevealTest(String theTestName, String[] theArguments, Object[] theResults) {
		arrArguments = Arrays.copyOf(theArguments, theArguments.length);
		arrResults = Arrays.copyOf(theResults, theResults.length);
	}

	/**
	 * Definition of arguments and results.
	 * 
	 * @return collection of arguments and results.
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	@Parameters(name="Testcase ''{0}'', Index {index}")
	public static Collection<Object[]> arguments() {

		List<Object[]> lstArguments = new ArrayList<>();
		String[] arguments = null;
		Object[] results = null;
		String name = null;

		// all issues
		name = "allissues";
		arguments = new String[]{
				"--input",
				"../../issues/issuedocument.xml",
				"--template",
				"../../export/revealtemplate.html",
				"--language",
				"de",
				"--output",
				String.format("../../export/%s.html", name),
		};
		results = new Object[]{Boolean.TRUE};

		lstArguments.add(new Object[]{name, arguments, results});

		return lstArguments;
	}
	
	/**
	 * Executes one test.
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	@Test
	public void testConvertAlternative() {

		boolean bSuccess = IssuesToReveal.executeOperation(arrArguments);

		Assert.assertEquals(arrResults[0], bSuccess);

	}

}

/* EOF */
