/*
 * JGAAP -- a graphical program for stylometric authorship attribution
 * Copyright (C) 2009,2011 by Patrick Juola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package com.jgaap.eventDrivers;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.jgaap.generics.Event;
import com.jgaap.generics.EventGenerationException;
import com.jgaap.generics.EventSet;

/**
 * @author Patrick Juola
 *
 */
public class VowelInitialWordEventDriverTest {

	/**
	 * Test method for {@link com.jgaap.eventDrivers.VowelInitialWordEventDriver#createEventSet(com.jgaap.generics.Document)}.
	 * @throws EventGenerationException 
	 */
	@Test
	public void testCreateEventSetDocumentSet() throws EventGenerationException {
		/* test case 1 -- no punctuation */
		String text = (
"alpha bravo charlie delta echo foxtrot golf hotel india " +
"juliet kilo lima mike november oscar papa quebec romeo " +
"sierra tango uniform victor whiskey x-ray yankee zebra " +
"Alpha Bravo Charlie Delta Echo Foxtrot Golf Hotel India " +
"Juliet Kilo Lima Mike November Oscar Papa Quebec Romeo " +
"Sierra Tango Uniform Victor Whiskey X-ray Yankee Zebra " +
"_none ?of #these *should 1be 4included +in ^output"
		);

		EventSet sampleEventSet = new VowelInitialWordEventDriver().createEventSet(text.toCharArray());
		EventSet expectedEventSet = new EventSet();
		Vector<Event> tmp = new Vector<Event>();

		tmp.add(new Event("alpha", null));
		tmp.add(new Event("echo", null));
		tmp.add(new Event("india", null));
		tmp.add(new Event("oscar", null));
		tmp.add(new Event("uniform", null));
		tmp.add(new Event("yankee", null));
		tmp.add(new Event("Alpha", null));
		tmp.add(new Event("Echo", null));
		tmp.add(new Event("India", null));
		tmp.add(new Event("Oscar", null));
		tmp.add(new Event("Uniform", null));
		tmp.add(new Event("Yankee", null));

		expectedEventSet.addEvents(tmp);
		assertTrue(expectedEventSet.equals(sampleEventSet));
	}
}
