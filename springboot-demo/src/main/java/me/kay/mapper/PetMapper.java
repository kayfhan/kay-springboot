package me.kay.mapper;

import me.kay.entities.Pet;
import org.apache.ibatis.annotations.*;

@Mapper  // MapperScan 二选一
public interface PetMapper {

    @Select("select * from pet where pet_id=#{petId}")
    public Pet getPetById(Integer petId);

    @Delete("delete from pet where pet_id=#{petId}")
    public int deletePetById(Integer petId);

    @Options(useGeneratedKeys = true, keyProperty = "petId")
    @Insert("insert into pet(pet_name) values(#{petName})")
    public int insertPet(Pet pet);

    @Update("update pet set pet_ame=#{petName} where pet_id=#{petId}")
    public int updatePet(Pet pet);
}
