import { Injectable } from '@angular/core';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
@Injectable({
  providedIn: 'root'
})
export class PdfService {

  pdfMake: any;
  etudiant;
  courses;
  constructor() { }

  async loadPdfMaker() {
    if (!this.pdfMake) {
      const pdfMakeModule = await import('pdfmake/build/pdfmake');
      const pdfFontsModule = await import('pdfmake/build/vfs_fonts');
      this.pdfMake = pdfMakeModule.default;
      this.pdfMake.vfs = pdfFontsModule.default.pdfMake.vfs;
    }
  }

  async generatePdf(courses) {
    this.etudiant=JSON.stringify(courses.etudiant)
    await this.loadPdfMaker();
    // @ts-ignore
    const def = { content: [
        {
          text: courses.cours.nom,
          style: 'header',
          bold: true,
          color: 'red',
          fontSize: 20,
          alignment: 'center',
          margin: [0, 0, 0, 20]
        },
        {
          text: 'Liste des Etudiants ',
          style: 'header',
          bold: false ,
          fontSize: 20,
          alignment: 'center',
          margin: [0, 0, 0, 20]
        },
        this.getetud(courses)




    // this.getEtud(),

      ]


    };
    this.pdfMake.createPdf(def).open();
  }
  /*getEtud(etud: this.courses.etudiant) {
    return {
      table: {
        widths: ['*', '*', '*', '*'],
        body: [
          [{
            text: 'Etudiants',
            style: 'tableHeader'
          },

          ],
          ...etud.map(ed => {
            return [ed.degree, ed.college, ed.passingYear, ed.percentage];
          })
        ]
      }
    };*/

  private getetud(courses) {
    // tslint:disable-next-line:no-unused-expression
    this.courses=courses.etudiant
   return {
     table: {
       alignment: 'center',
       headerRows: 1,
       widths: ['450', '100', '*', '*'],
       body: [
         [{
           text: 'Nom Complet',

           alignment: 'center',
           style:{
             margin:[40, 20, 0, 10]
           },
           bold: true

         }
         ],
         ...this.courses.map(ed => {
           return [{ text: ed,alignment:'center'}]
         })
       ],
       margin:[40, 20, 0, 40]
     },
alignment: 'center',
     }
}
}

