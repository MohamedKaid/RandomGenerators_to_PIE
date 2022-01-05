*This program is designed to compare three types of random generators, and to see which is closest to PI.

	*The program consists of two classes
		*The GCD class
			*This classes takes in the pair of integers that is generated and finds the gratest common divisor
		*The Main class
			*In this class the generators will get the hundred pairs of integers send them to the GCD class then if the 
				GCD=1 it will generate the estimit for Pi to allow us to compare.

	*Compile
		*Once the program is compiled it will go through all the steps mentioned earlier then at the end it will write all the
			estimits for each of the randomizers to a file called "Pi_Values.txt"

	*inputs and outputs
		*inputs
			*x, first integer from the set of randomized pair of numbers
			*y, second integer from the set of randomized pair of numbers
		*outputs
			*GCD, the greatest commen divisor
			*avg, the average of gcds that equal one
			*PiAvg, the estimit of the pairs of numbers with a gcd of 1 to be compared to PI

//The third generator will take a little long to finish compile.