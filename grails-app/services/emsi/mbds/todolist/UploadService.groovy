package emsi.mbds.todolist

import grails.gorm.transactions.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class UploadService {

    def doUpload(MultipartFile file)
    {
        // TODO : Récupérer le fichier et l'enregistrer sur le disque ...
        // TODO : Enregistrer le fichier dans le dossier assets -> grailsApplication.config.file.basePath
        // TODO : Une fois le fichier enregistré il faudra créer un FileElement que l'on ajoutera à la Todolist
    }
}
