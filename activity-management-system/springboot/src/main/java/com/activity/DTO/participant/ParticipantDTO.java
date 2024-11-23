package com.activity.DTO.participant;

import com.activity.entity.participant.Participant;
import com.activity.entity.participant.ParticipantType;
import lombok.Data;


@Data
public class ParticipantDTO {
    private Integer id;
    private String name;
    private Boolean valid;

    private Integer typeId;
    private String typeName;

    public static ParticipantDTO build(Participant participant){
        ParticipantDTO participantDTO = new ParticipantDTO();

        participantDTO.setId(participant.getId());
        participantDTO.setName(participant.getName());
        participantDTO.setValid(participant.getValid());

        participantDTO.setTypeId(participant.getType().getId());
        participantDTO.setTypeName(participant.getType().getName());

        return participantDTO;
    }
    public static Participant parse(ParticipantDTO participantDTO){
        Participant participant = new Participant();

        participant.setId(participantDTO.getId());
        participant.setName(participantDTO.getName());
        participant.setValid(participantDTO.getValid());

        ParticipantType participantType = new ParticipantType();
        participantType.setId(participantDTO.getTypeId());
        //participantType.setName(participantDTO.getTypeName());

        return participant;
    }
}
