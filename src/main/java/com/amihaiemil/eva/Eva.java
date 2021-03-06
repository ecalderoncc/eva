/*
 Copyright (c) 2016, Mihai-Emil Andronache
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification,
 are permitted provided that the following conditions are met:
 1. Redistributions of source code must retain the above copyright notice,
 this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.
 3. Neither the name of the copyright holder nor the names of its contributors
 may be used to endorse or promote products derived from this software
 without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 ARE DISCLAIMED.
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.eva;

/**
 * Interface of an evolutionary algorithm implementation.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 */
public interface Eva {

    /**
     * Run the algorithm, calculate the solution.
     * @return The found solution.
     */
    Solution calculate();

    /**
     * It is <b>mandatory</b> to specify a fitness evaluator.
     * @param evaluator The evaluator that this algorithm works with.
     * @return A new, copied instance, of this algorithm, with the specified FitnessEvaluator.
     */
    Eva with(FitnessEvaluator evaluator);

    /**
     * It is <b>mandatory</b> to specify a solution generator.
     * @param generator The generator that this algorithm works with.
     * @return A new, copied instance, of this algorithm, with the specified SolutionsGenerator.
     */
    Eva with(SolutionsGenerator generator);

    /**
     * Optionally, you can specify stopping conditions so the algorithm stops faster, if it finds
     * a matching solution. <b>Ideally, the found solution should always meet this Condition, but this is
     * not guaranteed!</b> <br><br>
     * 
     * The idea of a Condition is to make the algorithm faster and minimize the occasions when a
     * good solution is missed.<br><br>
     * 
     * By having a good and reasonable Condition, the algorithm can find a satisfactory solution very quickly!
     * @param stoppingConditions The added condition(s).
     * @return A new, copied instance, of this algorithm, with the specified Condition.
     */
    Eva with(Condition stoppingConditions);

    /**
     * Optionally, you can specify how the current generation of solutions is replaced by
     * the new one for the next iteration. By default, the current generation is <b>entirely</b>
     * replaced by the new one.<br><br>
     * 
     * It is advisable to specify a replacement that best fits your needs. Just extend abstract
     * class {@link GenerationReplacement} and feed it to the algorithm using this method.
     * @param replacement General Replacement
     * @returnA new, copied instance, of this algorithm, with the specified GenerationReplacement.
     */
    Eva with(GenerationReplacement replacement);

    /**
     * Get the stopping condition(s) of this algorithm. 
     * @return Stopping conditions.
     */
    Condition conditions();
    
    /**
     * Optionally, you can specify the way an individual solution is selected from the population
     * (i.e. when selecting the parents to create a new solution).
     * By default, the best out of 2 randomly chosen solution is selected.
     * @param selection The Selection implementation.
     * @return A new, copied instance, of this algorithm, with the specified Selection.
     */
    Eva with(Selection selection);
    
    /**
     * Optionally, you can specify how the best solution is selected from the population.
     * By default, the solution with the highest fitness is considered the best.
     * @param bestSelection The BestSelection implementation.
     * @return A new, copied instance, of this algorithm, with the specified BestSelection.
     */
    Eva with(BestSelection bestSelection);
}
