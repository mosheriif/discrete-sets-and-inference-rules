# Sets and Inference Rules

This repository contains the solution for **Lab 2: Sets + Inference Rules**, assigned for the (CSE214) Discrete Structures course. The assignment involves generating power sets, and implementing an inference engine using Java.

## Project Structure

- `src/` - Contains Java source files for the lab.

## Assignment Overview

### Part 1: Power Set

Generates the power set of a given set (array list of distinct strings) using recursive approach:

### Part 2: Inference Engine

Implements an inference engine to apply inference rules to logical expressions, supporting the following rules:
- **Modus Ponens**: Infers `Q` from `P > Q` and `P`.
- **Modus Tollens**: Infers `~P` from `P > Q` and `~Q`.
- **Hypothetical Syllogism**: Infers `P > R` from `P > Q` and `Q > R`.
- **Disjunctive Syllogism**: Infers `Q` from `P v Q` and `~P`.
- **Resolution**: Infers `Q v R` from `P v Q` and `~P v R`.

## Interfaces

The following interfaces are required:
- `Expression`: Represents logical expressions.
- `InferenceRule` and `InferenceEngine`: Define the structure of inference rules and their application in the engine.

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/mosheriif/discrete-sets-and-inference-rules.git
   ```

2. Compile the Java files:
   ```bash
   javac src/*.java
   ```

3. Run the main class:
   ```bash
   java src.Main
   ```

## Assumptions

- For the power set implementation, it is assumed that the format for the set is [a,b,c,d..], with commas between each element and no spaces and bounded by square brackets.
- For the inference engine, the input is only in the form “expressions are <exp1> and <exp2>” as stated in the examples provided in the lab description.
- Binary expressions are in the form x<operator>y with no spaces in between.
- Unary negation operations are in the form ~x with no spaces either.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
