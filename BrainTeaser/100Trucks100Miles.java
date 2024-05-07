package BrainTeaser;

// Given a fleet of 50 trucks, each with a full fuel tank and a range of 100 miles. 
// How far can you deliver a payload? 
// You can transfer the payload from truck to truck, and you can transfer fuel from truck to truck. Extend your answer for n trucks.
// Assuming each truck starts with 100 fuel and each mile consumes 1 fuel.
// Assuming the payload will not affect the fuel consumption.
// Assuming the fuel can be transferred from one truck to another without loss.

// This pattern is a converging series, which is a series that approaches a given number.
// The sum of the first n terms of a converging series is given by the formula:
// S = a / (1 - r)
// in this case, a = 100, r = 1/100
// S = 100 / (1 - 1/100) = 100 / (99/100) = 100 * 100 / 99 = 10000 / 99 = 101.01

// Solution:
// All trucks should start together.
// For 1st mile, the last truck (100th) will refill all of its fuel (99) to the 99 trucks, 99 trucks left, each truck with 100 fuel
// For 2nd mile, the last truck (99th) will refill all of its fuel (98) to the 98 trucks, 98 trucks left, each truck with 100 fuel
// For 3rd mile, the last truck (98th) will refill all of its fuel (97) to the 97 trucks, 97 trucks left, each truck with 100 fuel
// ...
// For 99th mile, the last truck (2nd) will refill all of its fuel (1) to the 1 truck, 1 truck left, the truck will have 100 fuel
// The 1st truck at 99 mile will have 100 fuel and have 100 fuel left, so it can go 100 more miles.

// so


public class 100Trucks100Miles {



    
}
