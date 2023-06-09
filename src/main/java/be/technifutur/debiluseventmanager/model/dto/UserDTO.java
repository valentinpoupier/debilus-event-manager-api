package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String gender;
    private String characterId;
    private String characterName;
    private List<JobDTO> jobs;
    private RankDTO rank;
    private RaceDTO race;
    private List<LocalDate> registrationHistories;
    private boolean isActive;

    public static UserDTO from(User entity){
        if (entity == null) {
            return null;
        }
        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .gender(entity.isGender() ? "Male" : "Female")
                .characterId(entity.getCharacterId())
                .characterName(entity.getCharacterName())
                .jobs(entity.getJobs().stream().map(JobDTO::from).toList())
                .rank(RankDTO.from(entity.getRank()))
                .race(RaceDTO.from(entity.getRace()))
                .registrationHistories(entity.getRegistrationHistories().stream().map(RegistrationHistoryDTO::from).map(RegistrationHistoryDTO::getDate).toList())
                .isActive(entity.isActive())
                .build();
    }

}
