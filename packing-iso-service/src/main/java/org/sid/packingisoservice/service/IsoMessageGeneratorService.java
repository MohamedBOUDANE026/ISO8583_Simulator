package org.sid.packingisoservice.service;

import lombok.RequiredArgsConstructor;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOException;
import org.jpos.iso.packager.ISO87APackager;
import org.sid.packingisoservice.dto.TransactionDTO;
import org.sid.packingisoservice.feign.ResponseIsoFeignClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class IsoMessageGeneratorService {

    private final ResponseIsoFeignClient responseIsoFeignClient;

    public String generateIsoMessage(TransactionDTO dto) throws ISOException {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(new ISO87APackager()); // ✅ Sans fichier XML

        isoMsg.setMTI("0200");
        isoMsg.set(2, dto.getNumeroCarte());
        isoMsg.set(3, "000000");
        isoMsg.set(4, String.format("%012d", dto.getMontant().multiply(new BigDecimal("100")).intValue()));
        isoMsg.set(7, new SimpleDateFormat("MMddHHmmss").format(new Date()));
        isoMsg.set(11, "123456");
        isoMsg.set(49, dto.getDevise());

        byte[] data = isoMsg.pack();
        String isoMessage = new String(data);

        // Appel Feign vers ResponseIsoService
        responseIsoFeignClient.sendIsoMessage(isoMessage);

        return isoMessage;
    }
}
