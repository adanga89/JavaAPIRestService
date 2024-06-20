package com.technicalevaluation.techeval.entity;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author adan_ga
 */
@Data
public class PokemonInfo {
    private float id;
    private boolean is_default;
    private String location_area_encounters;
    ArrayList < Object > abilities = new ArrayList <> ();
    ArrayList < Object > moves = new ArrayList <> ();
    private String name;
    private float order;
    ArrayList < Object > past_abilities = new ArrayList<>();
    ArrayList < Object > past_types = new ArrayList<>();
    Species SpeciesObject;
    Sprites SpritesObject;
    ArrayList < Object > stats = new ArrayList<>();
    ArrayList < Object > types = new ArrayList<>();
    private float weight;
} 

@Data
class Sprites {
    private String back_default;
    private String back_female = null;
    private String back_shiny;
    private String back_shiny_female = null;
    private String front_default;
    private String front_female = null;
    private String front_shiny;
    private String front_shiny_female = null;
    Other OtherObject;
    Versions VersionsObject;
}

@Data
class Versions {
 Generation_i Generation_iObject;
 Generation_ii Generation_iiObject;
 Generation_iii Generation_iiiObject;
 Generation_iv Generation_ivObject;
 Generation_v Generation_vObject;
 Generation_vi Generation_viObject;
 Generation_vii Generation_viiObject;
 Generation_viii Generation_viiiObject;
}

@Data
class Generation_viii {
 Icons IconsObject;
}

@Data
class Icons {
 private String front_default;
 private String front_female = null;
}

@Data
class Generation_vii {
 Icons IconsObject;
 Ultra_sun_ultra_moon Ultra_sun_ultra_moonObject;
}

@Data
class Ultra_sun_ultra_moon {
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}

@Data
class Generation_vi {
 Omegaruby_alphasapphire Omegaruby_alphasapphireObject;
 X_y X_yObject;
}
@Data
class X_y {
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}
@Data
class Omegaruby_alphasapphire {
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}
@Data
class Generation_v {
 Black_white Black_whiteObject;
}
@Data
class Black_white {
 Animated AnimatedObject;
 private String back_default;
 private String back_female = null;
 private String back_shiny;
 private String back_shiny_female = null;
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}

@Data
class Animated {
 private String back_default;
 private String back_female = null;
 private String back_shiny;
 private String back_shiny_female = null;
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}

@Data
class Generation_iv {
 Diamond_pearl Diamond_pearlObject;
 Heartgold_soulsilver Heartgold_soulsilverObject;
 Platinum PlatinumObject;
}
@Data
class Platinum {
 private String back_default;
 private String back_female = null;
 private String back_shiny;
 private String back_shiny_female = null;
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}

@Data
class Heartgold_soulsilver {
 private String back_default;
 private String back_female = null;
 private String back_shiny;
 private String back_shiny_female = null;
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}

@Data
class Diamond_pearl {
 private String back_default;
 private String back_female = null;
 private String back_shiny;
 private String back_shiny_female = null;
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}

@Data
class Generation_iii {
 Emerald EmeraldObject;
 Firered_leafgreen Firered_leafgreenObject;
 Ruby_sapphire Ruby_sapphireObject;
}

@Data
class Ruby_sapphire {
 private String back_default;
 private String back_shiny;
 private String front_default;
 private String front_shiny;
}
@Data
class Firered_leafgreen {
 private String back_default;
 private String back_shiny;
 private String front_default;
 private String front_shiny;
}
@Data
class Emerald {
 private String front_default;
 private String front_shiny;
}
@Data
class Generation_ii {
 Crystal CrystalObject;
 Gold GoldObject;
 Silver SilverObject;
}
@Data
class Silver {
 private String back_default;
 private String back_shiny;
 private String front_default;
 private String front_shiny;
 private String front_transparent;
}
@Data
class Gold {
 private String back_default;
 private String back_shiny;
 private String front_default;
 private String front_shiny;
 private String front_transparent;
}
@Data
class Crystal {
 private String back_default;
 private String back_shiny;
 private String back_shiny_transparent;
 private String back_transparent;
 private String front_default;
 private String front_shiny;
 private String front_shiny_transparent;
 private String front_transparent;
}
@Data
class Generation_i {
 Red_blue Red_blueObject;
 Yellow YellowObject;
}
@Data
class Yellow {
 private String back_default;
 private String back_gray;
 private String back_transparent;
 private String front_default;
 private String front_gray;
 private String front_transparent;
}
@Data
class Red_blue {
 private String back_default;
 private String back_gray;
 private String back_transparent;
 private String front_default;
 private String front_gray;
 private String front_transparent;
}
@Data
class Other {
 Dream_world Dream_worldObject;
 Home HomeObject;
 Official_artwork Official_artworkObject;
 Showdown ShowdownObject;
}
@Data
class Showdown {
 private String back_default;
 private String back_female = null;
 private String back_shiny;
 private String back_shiny_female = null;
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}
@Data
class Official_artwork {
 private String front_default;
 private String front_shiny;
}
@Data
class Home {
 private String front_default;
 private String front_female = null;
 private String front_shiny;
 private String front_shiny_female = null;
}
@Data
class Dream_world {
 private String front_default;
 private String front_female = null;
}
@Data
class Species {
 private String name;
 private String url;
}
@Data
class Cries {
 private String latest;
 private String legacy;
}