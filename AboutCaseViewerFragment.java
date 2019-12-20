package com.example.myprojectui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutCaseViewerFragment extends Fragment {
    TextView textView,category,categories,someInfo;
    ImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.case_viewer, container, false);
        textView = (TextView) rootView.findViewById(R.id.heading);
        imageView = (ImageView)rootView.findViewById(R.id.caseimageView);
        category = (TextView)rootView.findViewById(R.id.CategorizationHeading);
        categories = (TextView)rootView.findViewById(R.id.categories);
        someInfo = (TextView)rootView.findViewById(R.id.someInfo);
        setCriminalInfo();
        return rootView;
    }
    public void setTextInFragment(int index){
        if(index==0){
            setCriminalInfo();
        }
        else if(index==1){
            setDomesticInfo();
        }
        else if(index==2){
            setConsumerInfo();
        }
        else if(index==3){
            setTrafficInfo();
        }
    }

    private void setCriminalInfo() {
        textView.setText("Criminal");
        imageView.setImageResource(R.drawable.criminal4);
        category.setText("Some examples of Criminal cases include: ");
        categories.setText("Financial fraud\n" +
                "Bank robbery\n" +
                "Counterfeiting\n" +
                "Kidnapping\n" +
                "Threatening the president or other federal officials or buildings\n" +
                "Committing a crime on federal property\n" +
                "Committing a crime using interstate commerce\n" +
                "Committing a crime that involves a conspiracy\n" +
                "Using a firearm to commit a crime\n" +
                "Manufacturing and distributing controlled substances");
        someInfo.setText("Criminal Procedure\n" +
                "Overview\n" +
                "Criminal procedure deals with the set of rules governing the series of proceedings through which the government enforces substantive criminal law. Municipalities, states, and the federal government each have their own criminal codes, defining types of conduct that constitute crimes. Title 18 of the U.S. Code outlines all federal crimes. Typically, federal crimes deal with activities that either extend beyond state boundaries or directly impact federal interests.\n" +
                "\n" +
                "Federal prosecutions follow the Federal Rules of Criminal Procedure, cited as Fed. R. Crim. P., which the U.S. Supreme Court promulgated and Congress passed. The Federal Rules outline the procedure for conducting federal criminal trials. The Federal Rules incorporate and expound upon all guarantees included within the U.S. Constitution's Bill of Rights, such as the guarantee to due process and equal protection, the right to legal counsel, the right to confront witnesses, the right to a jury trial, and the right to not testify against oneself.\n" +
                "\n" +
                "State prosecutions follow the criminal procedure code of the individual state. Although every state has its own criminal procedure code, many states choose to mimic the Federal Rules. State procedural rules may offer greater protection to a defendant in a criminal trial than the U.S. Constitution or the Federal Rules, but may not offer less protection than guaranteed by the U.S. Constitution.\n" +
                "\n" +
                "Investigatory and Accusatory Police Procedure\n" +
                "The U.S. Constitution, the Federal Rules, state and local rules, and court interpretation of these documents not only set out how trials are run, but also prescribe the procedures that law enforcement agencies must follow. Should an officer fail to abide by the proper procedure, the trial court may suppress evidence obtained in violation of proper procedure, which could even lead to the suspect's acquittal. \n" +
                "\n" +
                "Law enforcement agencies are limited in their abilities well before an arrest is made. A portion of the criminal procedure process deals with an officersí ability to stop individuals, search them or their properties, and seize any incriminating evidence the officer finds. This pre-arrest investigation is limited by the Fourth, Fifth, Sixth, and Fourteenth Amendments.\n" +
                "\n" +
                "Sentencing\n" +
                "General\n" +
                "Sentencing usually occurs immediately for infractions and misdemeanors. For such minor infractions penalties may include probation; fines; short-term incarceration; long-term incarceration; suspended sentence, which only takes effect if the convict fails to meet certain conditions; payment of restitution to the victim; community service; or drug and alcohol rehabilitation.\n" +
                "\n" +
                "More serious crimes result in the trier of fact hearing evidence and arguments from both the prosecution and the defense regarding the appropriate sentence. Some jurisdictions allow the judge alone to determine the sentence; others will have a separate sentencing phase trial, complete with a new jury, to determine the sentence for certain crimes.\n" +
                "\n" +
                "During a sentencing trial, the prosecution presents evidence of aggravating factors, and the defense presents evidence of mitigating factors. The U.S. Supreme Court has interpreted the U.S. Constitution to protect the right to a jury sentencing trial for all defendants facing the death penalty.\n" +
                "\n" +
                "Stages of a Trial\n" +
                "Bail\n" +
                "After law enforcement arrests a suspect, a judge will set the suspect's initial bail, which is a specified amount of cash that allows the defendant to get out of jail after the initial arrest. If the defendant shows up for the proper court dates, the court refunds the bail, but if the defendant skips the date, then the court keeps the bail and issues a warrant for the individual's arrest.\n" +
                "\n" +
                "Arraignment\n" +
                "The arraignment comes next. During an arraignment, a judge calls an individual charged with committing a crime, reads to the individual the criminal charges against laid against him or her, asks the accused whether the accused has access to an attorney or needs the assistance of a court-appointed attorney, asks the accused to plead, decides whether to amend the initial bail amount, and sets the dates of future proceedings.\n" +
                "\n" +
                "Preliminary Hearing\n" +
                "The preliminary hearing follows the arraignment. At the preliminary hearing, the judge determines whether enough evidence exists for the prosecution to meet its burden of persuasion. The burden of persuasion refers to whether the prosecution even has enough evidence to make the defendant stand trial. The defense has the right to cross examine the government witnesses during this proceeding. Under the Fifth Amendment, a grand jury, rather than a judge, makes this determination when the defendant is charged with a \"capital or infamous crime.\n");
    }

    private void setDomesticInfo() {
        textView.setText("Domestic");
        imageView.setImageResource(R.drawable.domestic1);
        category.setText("Some examples of Domestic cases include: ");
        categories.setText("\n" +
                "Emotional Abuse\n" +
                "Physical Abuse\n" +
                "Sexual Abuse\n" +
                "Financial Abuse\n" +
                "Psychological Abuse");
        someInfo.setText("Domestic:\n" +
                "Questions as Framed for the Court by the Parties \n" +
                "Section 117(a) of Title 18 of the United States Code makes it a federal crime for any person to ìcommit[] a domestic assault within the special maritime and terri-torial jurisdiction of the United States or Indian coun-tryî if the person ìhas a final conviction on at least 2 separate prior occasions in Federal, State, or Indian tribal court proceedings forî enumerated domestic-violence offenses. 18 U.S.C. 117(a) (Supp. II 2014). \n" +
                "THE SIXTH AMENDMENT AND SUPREME COURT PRECEDENT\n" +
                "The Government argues that Bryantís conviction under 18 U.S.C. ß 117(a) is constitutionally admissible because the relevant question in this case concerns whether the prior convictions violated the Sixth Amendment, not whether Bryant did not have counsel at the prior proceeding. See Brief for Petitioner at 28. According to the Government, if Bryantís convictions did not violate the Sixth Amendment, they can be used in a later prosecution. See id. The Government further argues that Bryantís convictions did not violate the Sixth Amendment because they were obtained by Indian tribal governments which are not subject to the Sixth Amendment. See id. at 28ñ29. The Government asserts that the Courtís holdings in Burgett v. Texas, 389 U.S. 109 (1967), and Nichols v. United States, 511 U.S. 738 (1994) are particularly relevant here.  See Brief for Petitioner at 29; see also Nichols v. United States, 511 U.S. 738 (1994); Burgett v. Texas, 389 U.S. 109 (1967). The Government argues that Burgett, which held that a prior, uncounseled conviction obtained in violation of the Sixth Amendment right to counsel could not be used in a later prosecution, does not bar the use of the convictions here because the Sixth Amendment was never violated in the first place. See Brief for Petitioner at 22, 29. Instead, according to the Government, the convictions were obtained outside of the Sixth Amendmentís jurisdiction. See id. at 29. The Government asserts that the Court should instead follow Nichols, which held that a prior, uncounseled misdemeanor conviction carrying no term of imprisonment could be used in a later prosecution for a crime carrying a term of imprisonment, thus making Bryantís tribal-court convictions valid and permissible for use in his ß 117(a) prosecution. See id. at 24, 29. The Government also contends that the Ninth Circuitís reasoning was erroneous because it was based on now-overruled Supreme Court case law and that the Ninth Circuit misapplied Nichols. See id. at 30ñ32. The Government argues that Bryantís prior convictions conform with the Sixth Amendment, as the defendantís prior convictions did in Nichols, because the Sixth Amendment did not apply to the prior convictions. See id. at 32.\n" +
                "\n" +
                "PREVENTING SERIOUS DOMESTIC VIOLENCE CRIMES IN INDIAN COUNTRY\n" +
                "The Government and supporting amici fear that the Ninth Circuitís decision to disallow uncounseled tribal court convictions to satisfy ß 117(a)ís predicate-offense requirement will tie federal prosecutorsí hands in attempting to prevent serious domestic abuse crimes in Indian Country. See Brief of Amici Curiae Dennis K. Burke, Former United States Attorney, District of Arizona, et al., in Support of Petitioner at 5. A group of former United States Attorneys argues that domestic abuse offenders have extremely high recidivism rates and are more likely than other types of criminals to reoffend. See id. Additionally, they note that, for this class of crime, the severity of the violence usually increases with each subsequent offense. See id. at 7. Accordingly, amici contend that ß 117(a) is an important way for prosecutors to increase the level of punishment to match the escalating nature of violence present in cases of repeat offenders. See id. at 9. Amici argue that if the Court finds that ß 117(a) is inapplicable to uncounseled tribal court convictions, federal prosecutors would be deprived of one of their most valuable tools in the fight against domestic violence. See id. at 10.");
    }
    private void setConsumerInfo() {
        textView.setText("Consumer");
        imageView.setImageResource(R.drawable.consumer2);
        category.setText("Some examples of Consumer cases include: ");
        categories.setText("Mortgage Fraud\n" +
                "Debit Card Fraud\n" +
                "Fake Charities\n" +
                "Fake Lotteries");
        someInfo.setText("Consumer Protection Laws\n" +
                "Definition from Noloís Plain-English Law Dictionary\n" +
                "Federal and state laws established to protect retail purchasers of goods and services from inferior, adulterated, hazardous, and deceptively advertised products, and deceptive or fraudulent sales practices; these laws cover everything from food to cosmetics, from banking to fair housing. Most states have established agencies to actively protect the consumer.\n" +
                "Definition provided by Noloís Plain-English Law Dictionary.\n" +
                "\n" +
                "investigative consumer report\n" +
                "A consumer report from a consumer reporting agency that includes information on a person's character, general reputation, personal characteristics, or lifestyle that is based at least in part on personal interviews with the person's friends, family members, neighbors, and others who have information about the person. To request an investigative consumer report, the person making the request must follow the procedures laid out in the Fair Credit Reporting Act. (See: consumer report, consumer protection laws)\n" +
                "\n" +
                "Federal Trade Commission (FTC)\n" +
                "A federal government agency established to regulate business practices and enforce antitrust laws. The FTC often shows up in the news when big businesses attempt to merge, but it also plays a role in protecting consumers from unfair business practices, including actions by collection agencies and credit bureaus. While the FTC generally does not have authority to intervene in specific consumer disputes, it can take action against a company about which it has received numerous consumer complaints.");
    }
    private void setTrafficInfo() {
        textView.setText("Traffic");
        imageView.setImageResource(R.drawable.traffic4);
        category.setText("Some US Traffic Rules include: ");
        categories.setText("Steering wheels are always situated on the left side of the car.\n" +
                "Always drive on the right side of the road.\n" +
                "White lines separate lanes of traffic traveling the same direction.\n" +
                "Hashed or broken lines means you may change lanes when it is safe.\n" +
                "Solid white lines mean stay in your lane.\n" +
                "Yellow lines separate traffic moving in opposing directions.\n" +
                "Hashed or broken yellow lines mean you can carefully pass, paying attention to oncoming traffic.\n" +
                "Never cross a solid yellow line (or double yellow line).\n" +
                "When turning left at an intersection, pass in front of any cars that are turning left from the opposing direction (Do not try to pass behind them).\n" +
                "Use the left lane to pass other cars traveling your direction.\n" +
                "Do not pass in the right lane unless absolutely necessary.\n" +
                "If you are driving in the far left hand lane and someone would like to pass you, move over to the right lane when it is safe to do so and allow them to pass.\n" +
                "You must ALWAYS yield to pedestrians.");
        someInfo.setText("Traffic:\n" +
                "210.3 Policy.\n" +
                "(a) It is the policy of the Department of Defense that an effective, comprehensive traffic safety program be established and maintained at all military installations as prescribed in DoD Directive 6055.4. 1\n" +
                "\n" +
                "(b) State vehicular and pedestrian traffic laws that are now or may hereafter be in effect shall be expressly adopted and made applicable on military installations to the extent provided by this part. All persons on a military installation shall comply with the vehicular and pedestrian traffic laws of the state in which the installation is located.\n" +
                "\n" +
                "(c) Pursuant to the authority established in the Enclosure 1 to DoD Directive 5525.4 2, installation commanders of all DoD installations in the United States and over which the United States has exclusive or concurrent legislative jurisdiction are delegated the authority to establish additional vehicular and pedestrian traffic rules and regulations for their installations. All persons on a military installation shall comply with locally established vehicular and pedestrian traffic rules and regulations.\n" +
                "\n" +
                "2 See footnote 1 to ß 210.1.\n" +
                "\n" +
                "(d) A person found guilty of violating, on a military installation, any state vehicular or pedestrian traffic law or local installation vehicular or pedestrian traffic rule or regulation made applicable to the installation under the provisions of this part is subject to a fine of not more than $50 or imprisonment for not more than 30 days, or both, for each violation (40 U.S.C. 318c).\n" +
                "\n" +
                "(e) A copy of this part shall be posted in an appropriate place on the DoD installation concerned.\n");
    }
}
