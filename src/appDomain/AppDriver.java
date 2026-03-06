package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import shapes.BaseComparator;
import shapes.Shape;
import shapes.VolumeComparator;
import utilities.BubbleSort;
import utilities.HeapSort;
import utilities.InsertionSort;
import utilities.MergeSort;
import utilities.QuickSort;
import utilities.SelectionSort;

/**
 * @Author: Alexander Carlson
 * @Date: 2025-03-05
 * 
 * AppDriver is the main class for the application that reads shapes from a file,
 * sorts them based on user input, and prints the sorted shapes to the console.
 * 
 * <p>
 * Regarding Testing: All tests were run based on shape files provided in the res folder.
 * Results can vary based on hardware. The hardware used for these tests:
 * - CPU: 13th Gen Intel(R) Core(TM) i7-13650HX (2.60 GHz)
 * - RAM: 32 GB
 * - Storage: 1 TB M.2 SSD
 * - OS: Windows 11 Home 64-bit
 * </p>
 */
public class AppDriver
{
	/**
	 * The main method is the entry point of the application.
	 * 
	 * Command line arguments (order insensitive, case insensitive):
	 *   -f or -F followed by file_name (no spaces)
	 *   -t or -T followed by v (volume), h (height), or a (base area)
	 *   -s or -S followed by b (bubble), s (selection), i (insertion), m (merge), q (quick), z (heap)
	 * 
	 * EX: java -jar Sort.jar -fshapes1.txt -Tv -Sb
	 * 
	 * @param args The command line arguments to control execution.
	 */
	public static void main( String[] args )
	{
		if ( args.length == 0 )
		{
			printUsage();
			return;
		}

		// parse arguments in any order by checking the flag character
		String filePath = null;
		String sortType = null;
		String sortAlg  = null;

		for ( String arg : args )
		{
			if ( arg.length() < 3 )
			{
				System.out.println( "Invalid argument: " + arg );
				printUsage();
				return;
			}

			String flag  = arg.substring( 0, 2 ).toLowerCase();
			String value = arg.substring( 2 ).toLowerCase();

			switch ( flag )
			{
				case "-f":
					filePath = value;
					break;
				case "-t":
					sortType = value;
					break;
				case "-s":
					sortAlg = value;
					break;
				default:
					System.out.println( "Unknown argument: " + arg );
					printUsage();
					return;
			}
		}

		// validate all three required arguments were provided
		if ( filePath == null )
		{
			System.out.println( "Missing required argument: -f (file path)" );
			printUsage();
			return;
		}
		if ( sortType == null )
		{
			System.out.println( "Missing required argument: -t (sort type: v, h, a)" );
			printUsage();
			return;
		}
		if ( sortAlg == null )
		{
			System.out.println( "Missing required argument: -s (sort algorithm: b, s, i, m, q, z)" );
			printUsage();
			return;
		}

		// Read shapes into a Shape array 
		Shape[] shapes = readShapesFromFile( filePath );

		if ( shapes == null || shapes.length == 0 )
		{
			System.out.println( "No shapes were loaded from file: " + filePath );
			return;
		}

		// get comparator based on sort type
		Comparator<Shape> comparator = getComparator( sortType );
		if ( comparator == null )
		{
			System.out.println( "Invalid sort type: '" + sortType + "'. Please choose v, h or a." );
			printUsage();
			return;
		}

		// run the selected sort algorithm
		String sortName = "";
		long startTime  = System.currentTimeMillis();

		switch ( sortAlg )
		{
			case "b":
				new BubbleSort<Shape>().sort( shapes, comparator );
				sortName = "Bubble Sort";
				break;
			case "s":
				new SelectionSort<Shape>().sort( shapes, comparator );
				sortName = "Selection Sort";
				break;
			case "i":
				new InsertionSort<Shape>().sort( shapes, comparator );
				sortName = "Insertion Sort";
				break;
			case "m":
				new MergeSort<Shape>().sort( shapes, comparator );
				sortName = "Merge Sort";
				break;
			case "q":
				new QuickSort<Shape>().sort( shapes, comparator );
				sortName = "Quick Sort";
				break;
			case "z":
				new HeapSort<Shape>().sort( shapes, comparator );
				sortName = "Heap Sort";
				break;
			default:
				System.out.println( "Invalid sort algorithm: '" + sortAlg + "'. Please choose b, s, i, m, q or z." );
				printUsage();
				return;
		}

		long endTime = System.currentTimeMillis();

		// Print first element, every 1000th element, and last element
		System.out.println( "First element is:    " + shapes[0] );
		for ( int i = 1000; i < shapes.length; i += 1000 )
		{
			System.out.println( i + "-th element:    " + shapes[i] );
		}
		System.out.println( "Last element is:     " + shapes[shapes.length - 1] );
		System.out.println( sortName + " run time was: " + ( endTime - startTime ) + " milliseconds" );
	}

	/**
	 * Reads shapes from a file in the res/ folder and returns them as a Shape array.
	 * The first line of the file contains the number of shapes.
	 * Each subsequent line contains the shape type followed by its parameters.
	 * 
	 * @param filePath The name of the file (relative to the res/ folder).
	 * @return A Shape array containing all shapes read from the file.
	 */
	public static Shape[] readShapesFromFile( String filePath )
	{
		Shape[] shapes = null;
		int index = 0;
		/**
		 * FIX FOR RUNNING IN ECLIPSE: The file path should be relative to the project root, and the file should be located in the res/ folder.
		 */
		try ( BufferedReader br = new BufferedReader( new FileReader( filePath) ) ) // modified for runnable jar file. no res included in path
		{
			// first line contains the number of shapes
			String firstLine = br.readLine();
			if ( firstLine == null )
			{
				System.out.println( "File is empty: " + filePath );
				return new Shape[0];
			}

			int count = Integer.parseInt( firstLine.trim() );
			shapes    = new Shape[count];

			String line;
			while ( ( line = br.readLine() ) != null )
			{
				String[] values = line.trim().split( " " );
				if ( values.length < 3 ) continue; // skip malformed lines

				double param1 = Double.parseDouble( values[1] );
				double param2 = Double.parseDouble( values[2] );

				switch ( values[0] )
				{
					case "Cylinder":
						shapes[index++] = new shapes.Cylinder( param1, param2 );
						break;
					case "Cone":
						shapes[index++] = new shapes.Cone( param1, param2 );
						break;
					case "Pyramid":
						shapes[index++] = new shapes.Pyramid( param1, param2 );
						break;
					case "OctagonalPrism":
						shapes[index++] = new shapes.OctagonalPrism( param1, param2 );
						break;
					case "PentagonalPrism":
						shapes[index++] = new shapes.PentagonalPrism( param1, param2 );
						break;
					case "SquarePrism":
						shapes[index++] = new shapes.SquarePrism( param1, param2 );
						break;
					case "TriangularPrism":
						shapes[index++] = new shapes.TriangularPrism( param1, param2 );
						break;
					default:
						// Skip unknown shape types
						break;
				}
			}
		}
		catch ( IOException e )
		{
			System.out.println( "Error reading file: " + filePath );
			e.printStackTrace();
		}
		catch ( NumberFormatException e )
		{
			System.out.println( "Error parsing number in file: " + filePath );
			e.printStackTrace();
		}

		// trim array in case any lines were skipped
		if ( shapes != null && index < shapes.length )
		{
			Shape[] trimmed = new Shape[index];
			System.arraycopy( shapes, 0, trimmed, 0, index );
			return trimmed;
		}

		return shapes != null ? shapes : new Shape[0];
	}

	/**
	 * Returns the appropriate Comparator for the given sort type flag.
	 * 
	 * @param sortType "v" for volume, "a" for base area, "h" for height.
	 * @return The corresponding Comparator, or null if the sort type is invalid.
	 */
	public static Comparator<Shape> getComparator( String sortType )
	{
		switch ( sortType )
		{
			case "v":
				return new VolumeComparator();
			case "a":
				return new BaseComparator();
			case "h":
				return Comparator.naturalOrder(); // uses compareTo in Shape, which compares by height
			default:
				return null;
		}
	}

	/**
	 * Prints usage instructions to the console.
	 */
	private static void printUsage()
	{
		System.out.println( "\nUsage: java -jar Sort.jar -f<filename> -t<sortType> -s<algorithm>" );
		System.out.println( "  -f  File name in the res/ folder (e.g. -fshapes1.txt)" );
		System.out.println( "  -t  Sort type: v (volume), h (height), a (base area)" );
		System.out.println( "  -s  Algorithm: b (bubble), s (selection), i (insertion), m (merge), q (quick), z (heap)" );
		System.out.println( "  Arguments can be provided in any order and are case insensitive." );
		System.out.println( "  Example: java -jar Sort.jar -fshapes1.txt -Tv -Sb\n" );
	}
}