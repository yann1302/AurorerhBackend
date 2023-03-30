package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.ParamEtatDTO;
import com.advance.aurore_rh.dto.request.ReportParametersDTO;
import com.advance.aurore_rh.exceptions.ResourceNotFoundException;
import com.advance.aurore_rh.model.EtatImprimable;
import com.advance.aurore_rh.repository.EtatImprimableRepository;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SimpleReportService  {

    /**
     * The Generator tools.
     */
   // private final ReportGeneratorTools generatorTools;

   // @Autowired
    protected JdbcTemplate jdbcTemplates;

    @Autowired
    private  EtatImprimableRepository etatImprimableRepository;
//    private final WindowAppRepository windowsRepository;
//    private final RoleRepository roleRepository;
//    private final FiltreRepository filtreRepository;
    /**
     * The Data source.
     */
    //private final DataSource dataSource;

    /**
     * The constant MEDIA_TYPE.
     */
    public static final String MEDIA_TYPE = MediaType.APPLICATION_PDF_VALUE;

    /**
     * The Sdf.
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private final String SOCIETY_NAME = "ADVANCE IT";
    private final String SOCIETY_PHONE = "699 123 862 ";
    private final String SOCIETY_EMAIL = "ADVANCEIT@gmail.com";
    private final String SOCIETY_CODEPOSTAL = "BP: 1892";

    private final String REPORTS_DIR_PATH = System.getProperty("user.dir")+"/../reports/def/";
    private final String LOGO_PAR_DEFAUT = System.getProperty("user.dir")+"/../images/sucs-logo.png/";


//    /**
//     * Generate fature report response entity.
//     *
//     * @param doDomaine  the do domaine
//     * @param doType     the do type
//     * @param doPice     the do pice
//     * @param jasperFile the jasper file
//     * @return the response entity
//     * @throws SQLException    the sql exception
//     * @throws ParseException  the parse exception
//     * @throws EditorException the editor exception
//     * @throws IOException     the io exception
//     */
//    @Override
//    public ResponseEntity<?> generateFatureReport(int doDomaine, int doType, String doPice, MultipartFile jasperFile) throws SQLException, ParseException, EditorException, IOException {
//        HashMap<String, String> totaux = editor.getTotauxDocEntete(doPice, ""+doType);
//        HashMap<String, String> netAPayer = editor.getRecapOnPiedDocument(doPice, ""+doType);
//        log.info("Totaux {}", totaux);
//        log.info("Net a payer {}", netAPayer);
//        Map<String, Object> params = new HashMap<>();
//        params.put("REPORT_NAME", "Facture"); //TODO à configurer dans les paramètre global de l'application
//        params.put("SOCIETY_NAME", "Advance IT Group"); //TODO à configurer dans les paramètre global de l'application
//        params.put("SOCIETY_DESC", "STE INT DE IISS ET EXP AU CAM ET AFRIQUE"); //TODO à configurer dans les paramètre global de l'application
//        params.put("SOCIETY_PB", "B.P. 299 YAOUNDE"); //TODO à configurer dans les paramètre global de l'application
//        params.put("SOCIETY_DIST", "1");
//        params.put("DO_TYPE", doType);
//        params.put("DO_PIECE", doPice);
//        params.put("DO_DOMAINE", doDomaine);
//        params.put("REGLEMENT", netAPayer.get("TOTAL_REGLEMENTS"));
//        params.put("DATE_REGLEMENT", "/"); //TODO à compléter
//        params.put("TYPE_REGLEMENT", "/"); //TODO à compléter
//        params.put("TOTAL_ESCOMPTES", totaux.get("ESCOMPTE"));
//        params.put("TOTAL_REMISE", totaux.get("TOTAL_REMISE"));
//        params.put("TOTAL_TAXE", totaux.get("TOTAL_TAXE"));
//        params.put("TOTAL_ACOMPTES", netAPayer.get("TOTAL_ACOMPTES"));
//        params.put("TOTAL_TTC", netAPayer.get("TOTAL_TTC"));
//        params.put("TOTAL_HT", totaux.get("TOTAL_HT"));
//        params.put("NET_A_PAYER", netAPayer.get("NAP"));
//        params.put("PORT", "/"); //TODO à compléter
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(MEDIA_TYPE))
//                .body(generatorTools.generatePdfReportWithConnexion(jasperFile.getResource(), params, dataSource.getConnection()));
//    }


/*
PARTIELLEMENT FOCTIONNELLE
    @Override
    public ResponseEntity<byte[]> imprimerEtat(Integer doDomaine, Integer doType, String doPiece, HttpServletResponse response) throws SQLException, IOException, JRException {

        Connection connection = dataSource.getConnection();

        HashMap<String, Object> param = new HashMap<>();

        File file = ResourceUtils.getFile(REPORTS_DIR_PATH + "DOCUMENT_VENTE_FACTURE.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(facture());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
        HttpHeaders headers = new HttpHeaders();
       headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=DOCUMENT_VENTE_FACTURE.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }

 */


    public ResponseEntity<byte[]> imprimerEtat(ReportParametersDTO reportParametersDTO ) throws IOException, JRException, SQLException {

        Connection connection = jdbcTemplates.getDataSource().getConnection() ;

        EtatImprimable etatImprimable = etatImprimableRepository.findById(reportParametersDTO.getIdEtat()).orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",reportParametersDTO.getIdEtat()));
        ;
        // EtatImprimable etatImprimable = etatImprimableRepository.findById().orElseThrow(()-> new ResourceNotFoundException("Document de vente","le type","")); ;
        // String filtre = buildWhereClause(reportParametersDTO);
        //= etatImprimableRepository.findByNumeroOrdre(reportParametersDTO.getIdEtat());
        // orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",reportParametersDTO.getIdEtat() ));
/*

        if (!reportParametersDTO.getParamEtats().isEmpty()) {
            for (int i = 0; i < reportParametersDTO.getParamEtats().size(); i++) {
                ParamEtatDTO paramEtat = reportParametersDTO.getParamEtats().get(i);
                if (paramEtat.getTexte().equals("DO_TYPE") && ((Integer)paramEtat.getValeur() == 0 )) {
                    etatImprimable = etatImprimableRepository.findById(40L).orElseThrow(()-> new ResourceNotFoundException("Document de vente","le type",paramEtat.getValeur()));
                } if (paramEtat.getTexte().equals("DO_TYPE") && ((Integer)paramEtat.getValeur() >= 0 && (Integer)paramEtat.getValeur() <= 8)) {
                    etatImprimable = etatImprimableRepository.findById(40L).orElseThrow(()-> new ResourceNotFoundException("Document de vente","le type",paramEtat.getValeur()));
                }
                if (paramEtat.getTexte().equals("DO_TYPE") && ((Integer)paramEtat.getValeur() >= 10 && (Integer)paramEtat.getValeur() <= 18)) {
                    etatImprimable = etatImprimableRepository.findById(41L).orElseThrow(()-> new ResourceNotFoundException("Document d'achat","le type",paramEtat.getValeur()));
                }
                if (paramEtat.getTexte().equals("DO_TYPE") && ((Integer) paramEtat.getValeur() >= 20 && (Integer) paramEtat.getValeur() <= 27)) {
                    etatImprimable = etatImprimableRepository.findById(39L).orElseThrow(null);
                }
                if (paramEtat.getTexte().equals("DO_TYPE") && ((Integer)paramEtat.getValeur() >= 40 && (Integer)paramEtat.getValeur() <= 47)) {
                    etatImprimable = etatImprimableRepository.findById(39L).orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",paramEtat.getValeur()));
                }
                if (paramEtat.getTexte().equals("DO_TYPE") && ((Integer)paramEtat.getValeur() >= 28 && (Integer)paramEtat.getValeur() <= 39)) {
                    etatImprimable = etatImprimableRepository.findById(39L).orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",paramEtat.getValeur()));
                }
                if (paramEtat.getTexte().equals("DO_TYPE") && (Integer)paramEtat.getValeur() == 30) {
                    etatImprimable = etatImprimableRepository.findById(42L).orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",paramEtat.getValeur()));
                }
                if (paramEtat.getTexte().equals("TYPE")) {
                    etatImprimable = etatImprimableRepository.findById(10044L).orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",paramEtat.getValeur()));
                }
            }
        }else{
            etatImprimable = etatImprimableRepository.findById(reportParametersDTO.getIdEtat()).orElseThrow(()-> new ResourceNotFoundException("EtatEmprimable","idEtat",reportParametersDTO.getIdEtat()));
        }

*/

        //ParamSocietyDTO paramSocietyDTO = getParamSociety();

        HashMap<String, Object> param = new HashMap<>();
        // param.put("DO_DOMAINE", reportParametersDTO.getDoDomaine());
        //param.put("DO_TYPE",reportParametersDTO.getDoType());
        param.put("SOCIETY_LOGO", LOGO_PAR_DEFAUT);
        //  if(!filtre.isEmpty())APP_ACTE_MEDICAL
        // param.put("FILTRE",filtre);
        param.put("SOCIETY_NAME", SOCIETY_NAME);
        param.put("SOCIETY_TELEPHONE", SOCIETY_PHONE);
        param.put("SOCIETY_EMAIL", SOCIETY_EMAIL);
        param.put("SOCIETY_CODEPOSTAL", SOCIETY_CODEPOSTAL);
        String filename = "ETAT_" + etatImprimable.getLibelle() + "_" + LocalDateTime.now();

        FileSystemResource fsr = new FileSystemResource(REPORTS_DIR_PATH + etatImprimable.getChemin());
        InputStream jasperStream = fsr.getInputStream();
        File file = ResourceUtils.getFile(REPORTS_DIR_PATH + etatImprimable.getChemin());
        //JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(facture());
        Map<String, Object> params = new HashMap<>();
        // on elimine les cles n'ayant pas de valeur
        List<ParamEtatDTO> nonNulParams = reportParametersDTO.getParamEtats().stream().filter(paramEtatDTO -> Objects.nonNull(paramEtatDTO.getValeur())).collect(Collectors.toList());
        nonNulParams.forEach(para -> param.put(para.getTexte(),para.getValeur()));
        // Ajout de l'en-tete si xa n'existe pas encore

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, connection);
        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
        HttpHeaders headers = new HttpHeaders();
        //String prefix = RepportParamsUtils.replaceSpaceByUndescore(filename);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + ".pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

//    @Override
//    public Boolean existsByNumeroOrdre(int idEtat) {
//        return etatImprimableRepository.existsByNumeroOrdre(idEtat);
//    }
//
//    @Override
//    public List<EtatImprimable> saveManyEtats(AddEtatImprimableParamDTO addEtatImprimableParamDTO) {
//        WindowApp windowApp = windowsRepository.findById(addEtatImprimableParamDTO.getWindowsId())
//                .orElseThrow(() -> new ResourceNotFoundException("Fenetre", "id", addEtatImprimableParamDTO.getWindowsId()));
//        List<EtatImprimable> saved = new ArrayList<>();
//        List<Role> roleList = roleRepository.findAll();
//        addEtatImprimableParamDTO.getEtatImprimables().forEach(etatDTO -> {
//            if (!etatImprimableRepository.existsByLibelle(etatDTO.getLibelle())) {
//                EtatImprimable etatImprimable = EtatImprimableRequest.buildFromDTO(windowApp.getId(), etatDTO);
//                etatImprimable = etatImprimableRepository.save(etatImprimable);
//                /*
//                ActionSysteme actionSysteme = ActionSysteme.builder()
//                        .description(etatImprimable.getDescription())
//                        .fenetre(fenetre)
//                        .libelleAction("bouton imprimer " + etatImprimable.getLibelle())
//                        .idObjet(etatImprimable.getLibelle().toLowerCase().replace(" ", "-"))
//                        .typeObjet(5)
//                        .build();
//                final ActionSysteme actionSaved = actionSystemeRepository.save(actionSysteme);
//                roleList.forEach(role -> {
//                    RoleAction roleAction = RoleAction.builder()
//                            .action(actionSaved)
//                            .role(role)
//                            .conditionActif("false")
//                            .conditionEditable("false")
//                            .conditionVisible("false")
//                            .build();
//                    roleActionRepository.save(roleAction);
//
//
//                });
//
//                 */
//
//                saved.add(etatImprimable);
//            }
//        });
//        return saved;
//    }

//    public ParamSocietyDTO getParamSociety() {
//        String sql = RepportParamsUtils.getSQLForGetSociety();
//        log.info("Recuperation des parametres de la societe ==> {}", JsonUtil.getJson(sql));
//        return jdbcTemplate.queryForObject(sql, new Object[]{}, (rs, rowNum) ->
//                new ParamSocietyDTO(
//                        rs.getString("raisonSocial"),
//                        rs.getString("profession"),
//                        rs.getString("adresse"),
//                        rs.getString("complement"),
//                        rs.getString("codePastal"),
//                        rs.getString("ville"),
//                        rs.getString("siret"),
//                        rs.getString("pays"),
//                        rs.getString("ville"),
//                        rs.getString("identifiant"),
//                        rs.getString("email"),
//                        rs.getString("telephone"),
//                        rs.getString("telecopie"),
//                        rs.getString("site")));
//    }


//    @Override
//    public Iforce5ServiceResponseDto listeFiltres() {
//        List<Filtre> listeFiltre = filtreRepository.findAll();
//        return Iforce5ServiceResponseDto.Iforce5ServiceResponseDtoBuilder.aIforce5ServiceResponseDto()
//                .withCode(HttpStatus.OK.value())
//                .withData(listeFiltre)
//                .withMessage(systemService.findByCodeMessage(1001))
//                .build();
//    }
//
//    @Override
//    public boolean existsById(Long id) {
//        return etatImprimableRepository.existsById(id);
//    }
//
//    @Override
//    public Iforce5ServiceResponseDto deleteById(Long id) {
//        etatImprimableRepository.deleteById(id);
//        return Iforce5ServiceResponseDto.Iforce5ServiceResponseDtoBuilder.aIforce5ServiceResponseDto()
//                .withCode(HttpStatus.OK.value())
//                .withData(systemService.findByCodeMessage(1020))
//                .withMessage(systemService.findByCodeMessage(1001))
//                .build();
//    }
//
//    @Override
//    public Iforce5ServiceResponseDto listeFiltresTraiterEtat(Long id, Long traiter, HttpServletRequest request) {
//        // on verifie si l'etat existe
//        if (!etatImprimableRepository.existsById(id)) {
//            return generalNotFoundEntityResponse(HttpStatus.NOT_FOUND,id , String.format(systemService.findByCodeMessage(1027),"Etat","id",id));
//        }
//        if (traiter != 0 && traiter != 1) {
//            return generalNotFoundEntityResponse(HttpStatus.NOT_FOUND,traiter , "La valeur du champs traiter n'est pas accepté");
//        }
//        try {
//            int traiterSource = traiter.intValue();
//            ListeFiltreEtatDTO data = traiterSource > 0 ? findByIdEtat(id, traiterSource)
//                    : findByIdEtat(id);
//            return Iforce5ServiceResponseDto.Iforce5ServiceResponseDtoBuilder.aIforce5ServiceResponseDto()
//                    .withCode(HttpStatus.OK.value())
//                    .withData(data)
//                    .withMessage(systemService.findByCodeMessage(1001))
//                    .build();
//        } catch (Exception e) {
//            return returnGeneralErrorException(e.getMessage(), "listeFiltresTraiterEtat  -- Method Param -- =>> id : ", id, e);
//        }
//    }
//    public ListeFiltreEtatDTO findByIdEtat(Long idEtat, int traiterSource) {
//        EtatImprimable etatImprimable = etatImprimableRepository.findById(idEtat)
//                .orElseThrow(() -> new ResourceNotFoundException("EtatImprimable", "Id", idEtat));
//        final List<FiltreEtatImprimable> etatsFiltres = filtreEtatRepository.findAllByEtatImprimableId(idEtat);
//        List<FiltreEtatDTO> filtres = new ArrayList<>();
//        etatsFiltres.forEach(filtreEtatImprimable -> {
//            Filtre filtre = filtreEtatImprimable.getFiltre();
//            if (Objects.nonNull(filtre) && Objects.nonNull(filtre.getSourceDeDonnees()) && filtre.getSourceDeDonnees().trim().length() > 0) {
//                List<ParamEtatDTO> source = getResultListOfDataSource(filtre.getSourceDeDonnees());
//                filtres.add(FiltreEtatDTO.buildFromEntities(filtreEtatImprimable, filtre, source));
//            }
//        });
//        return ListeFiltreEtatDTO.buildFromEtatsAndFiltreEtatDTO(etatImprimable, filtres);
//    }
//
//
//    /**
//     * @param sourceDeDonnees Requete SQL a executer pour avoir les donnees
//     * @return un dto comprenant les resultats compiles
//     * @implSpec cette methode utilise le resultat d'une requete pour compiler un objet non manage par jpa
//     */
//    private List<ParamEtatDTO> getResultListOfDataSource(String sourceDeDonnees) {
//        Query query = entityManager.createNativeQuery(sourceDeDonnees);
//        List<Object[]> resultList = (List<Object[]>) query.getResultList();
//        return resultList.stream().map(array -> ParamEtatDTO.builder().texte(array[0] + "").valeur(array[1]).build())
//                .collect(Collectors.toList());
//    }
//    public ListeFiltreEtatDTO findByIdEtat(Long idEtat) {
//        EtatImprimable etat = etatImprimableRepository.findById(idEtat)
//                .orElseThrow(() -> new ResourceNotFoundException("EtatImprimable", "Id", idEtat));
//        final List<FiltreEtatImprimable> etatsFiltres = filtreEtatRepository.findAllByEtatImprimableId(idEtat);
//        return ListeFiltreEtatDTO.buildFromEntities(etat, etatsFiltres);
//    }
}
