# Solution Comments

The designed solution proposes in some parts a slightly different approach
different from the proposal not only presenting the selected parcels
as less Loss, but, a grouping of plots with the visualization
increasing losses where always in each block the first set of
installments represent the lowest loss in nominal values.

The grouping besides allowing a better visualization of the data attentive
for a mass of data prepared as an input for ML.

There is no normal distribution in the plots, but a correlation between
the number of parcels and total parcels generated in each case
also random in the generation of values.

# Execution times

* Process execution times were stored in seconds with file generation
csv of each process.

Generated file Runtime (s)
Loss_Result_1.csv 31.85s
Result_Loss_2.csv 32.157s
Loss_Result_3.csv 31.433s
Result_Loss_4.csv 32.198s
Result_Loss_5.csv 32.382s

Average Runtime: 32.004s

 
# Analyze

* In a preliminary analysis I observed a certain trend where in most cases it occurs more
a set of data representative of the "lowest loss" and / or the "repetition of nominal values" for
other sets of plots.

* In literally all cases the single installment holds the greatest loss regardless of its value.

* The increase in loss is almost linear in the set of losses representing data with low dispersion.

