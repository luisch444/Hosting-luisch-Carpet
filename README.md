# Hosting-luisch Carpet

This carpet extension mod created for servers that uses Hosting-luisch and want some custom carpets rules. But anyone can install it and suggest new rules or improvements.

The principals versions of the mod are 1.20 1.19.4 1.17 but if you want to another version just ask me via discord, or if you know you can always port it yourself and make a pull-request.

by luisch444 my discord: [discord](https://discord.gg/gGtqFXVh5q)

## Installation

This is a mod extension of [carpet-mod](https://github.com/gnembon/fabric-carpet) powered by [FabricMC](https://fabricmc.net/). To install all of it you must follow these rules:

1. Install the last [fabric loader](https://fabricmc.net/use/installer/)
2. Download the last updated version of carpet mod for the version you are going to play, [github-releases](https://github.com/gnembon/fabric-carpet/releases) [curseforge](https://www.curseforge.com/minecraft/mc-mods/carpet/files)
3. Download the last mod version of this carpet on [releases](https://github.com/luisch444/Hosting-luisch-Carpet/releases)
4. Move both mods to the `mod` folder located on `.minecraft` folder

## Rules

### deepslateInstaminable [class](/src/main/java/xyz/luisch444/carpet/mixin/AbstractBlockStateMixin.java)

> Use: /carpet {setdefault} deepslateInstaminable true/false
>
> Deepslate is instaminable with efficiency 5 and haste 2

### endstoneInstaminable [class](/src/main/java/xyz/luisch444/carpet/mixin/AbstractBlockStateMixin.java)

> Use: /carpet {setdefault} endstoneInstaminable true/false
>
> Endstone is instaminable with efficiency 5 and haste 2

### carefulBreak [class](/src/main/java/xyz/luisch444/carpet/mixin/BlockMixin.java)

>
> Use: /carpet {setdefault} carefulBreak ("never", "always", "sneaking", "no-sneaking")
>
> Places the mined block in the player inventory when sneaking.

### endermanNoGrief [class](/src/main/java/xyz/luisch444/carpet/mixin/EndermanEntityMixin.java)

>
> Use: /carpet {setdefault} endermanNoGrief true/false
>
> Endermans will not attempt to pick up any block

### villagersNoGenerateGolems [class](/src/main/java/xyz/luisch444/carpet/mixin/VillagerEntityMixin.java)

>
> Use: /carpet {setdefault} villagersNoGenerateGolems true/false
>
> Disable generation of iron golems by villagers

### stackeableTotems [class](/src/main/java/xyz/luisch444/carpet/mixin/ItemStackMixin.java)

>
> Use: /carpet {setdefault} stackeableTotems true/false
>
> Allows Totem been stacked (default=16 it depends on the rule stackeableTotemsSize)
#### stackeableTotemsSize
>
> Use: /carpet {setdefault} stackeableTotemsSize (1-64) <-- Could be more than 64 but in survival is not recommended
>
> Limit the amount of stacking in the rule [stackeableTotems](/README.md#stackeabletotems-class)

### enderPearlsNoCooldown [class](/src/main/java/xyz/luisch444/carpet/mixin/EndermanEntityMixin.java)

>
> Use: /carpet {setdefault} enderPearlsNoCooldown true/false
>
> Disable cooldown of enderpearls

### squidsNoSpawn [class](/src/main/java/xyz/luisch444/carpet/mixin/SquidEntityMixin.java)

>
> Use: /carpet {setdefault} squidsNoSpawn true/false
>
> Disable that squids spawns natural


## Building

### How to build

* First clone the repository `git clone https://github.com/luisch444/Hosting-luisch-Carpet.git`
* Set the "gradle.properties" file variables
* Generate the sources `./gradlew genSources`
* Then build the project `./gradlew build`
