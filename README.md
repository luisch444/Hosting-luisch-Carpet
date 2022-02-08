# Hosting-luisch Carpet

This carpet was created for servers that uses Hosting-luisch and want some custom carpets rules. Also if a friend ask me to create a rule I will do it (if I considerate)

by luisch444 my discord: [discord](https://discord.gg/gGtqFXVh5q)

## Rules

### deepSlate Instaminable [class](/src/main/java/xyz/luisch444/carpet/mixin/AbstractBlockStateMixin.java)

> Use: /carpet {setdefault} deepSlateInstaminable true/false
>
> This option make DeepSlate have the same hardness that stone

### endStone EndStone less Hardnes [class](/src/main/java/xyz/luisch444/carpet/mixin/AbstractBlockStateMixin.java)

> Use: /carpet {setdefault} edStonelessHardnes true/false
>
> This option make EndStone have the same hardness that stone

### carefulBreak [class](/src/main/java/xyz/luisch444/carpet/mixin/BlockMixin.java)

> coppied from epsilon carpet(1.16) https://github.com/EpsilonSMP/Epsilon-Carpet
> 
> Use: /carpet {setdefault} carefulBreak ("never", "always", "sneaking", "no-sneaking")
>
> Places the mined block in the player inventory when sneaking.

### endermanNoGrief [class](/src/main/java/xyz/luisch444/carpet/mixin/EndermanEntityMixin.java)

> 
> Use: /carpet {setdefault} endermanNoGrief true/false
>
> Endermans not tries to pick any block 

### villagersNoGenerateGolems [class](/src/main/java/xyz/luisch444/carpet/mixin/VillagerEntityMixin.java)

> 
> Use: /carpet {setdefault} villagersNoGenerateGolems true/false
>
> Villagers not generates golemns

### stackeableTotems [class](/src/main/java/xyz/luisch444/carpet/mixin/ItemStackMixin.java)

> 
> Use: /carpet {setdefault} stackeableTotems true/false
>
> Allows Totem been stacked (default=16 it depends on the rule stackeableTotemsSize)
#### stackeableTotemsSize 
>
> Use: /carpet {setdefault} stackeableTotemsSize (1-64) <-- Could be more than 64 but in survival is not recommended
>
> Limit the amount of stacking in the rule [stackeableTotems](/src/main/main/README.md#stackeabletotems-class)




