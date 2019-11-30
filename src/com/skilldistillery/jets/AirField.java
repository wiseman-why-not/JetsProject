package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	// fields
	private List<Jet> jets;

	public AirField() {
		jets = new ArrayList<>();

	}

	public List<Jet> readJet() {

		try (BufferedReader rd = new BufferedReader(new FileReader("jets.txt"))) {
			String line;

			// want to loop while there is another line to read
			while ((line = rd.readLine()) != null) {
				String[] jetRecord = line.split(", "); // split the line into an Array of Strings separated by ", ".

				Jet plane = null;

				switch (jetRecord[0]) {
				case "Fighter":		// its important to set JetRecord a array of Strings to be able to pass in as parameters.
					plane = new FighterJet(jetRecord[0], jetRecord[1], Double.parseDouble(jetRecord[2]),
							Integer.parseInt(jetRecord[3]), Long.parseLong(jetRecord[4]));
					jets.add(plane);
					break;
				case "Cargo":
					plane = new CargoPlane(jetRecord[0], jetRecord[1], Double.parseDouble(jetRecord[2]),
							Integer.parseInt(jetRecord[3]), Long.parseLong(jetRecord[4]));
					jets.add(plane);
					break;
				case "JetImpl":
					plane = new JetImpl(jetRecord[0], jetRecord[1], Double.parseDouble(jetRecord[2]),
							Integer.parseInt(jetRecord[3]), Long.parseLong(jetRecord[4]));
					jets.add(plane);
					break;
				default:
					System.out.println("something went wrong");
					// end of switch statement
				}
				// end of while loop
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jets;
		// end of readJet method
	}

}
