public class DailyLeadProcessor implements Schedulable {
    public void execute(SchedulableContext ctx) {
        List<Lead> leadsToUpdate = [SELECT Id, LeadSource FROM Lead WHERE LeadSource = null LIMIT 200];
        for (Lead lead : leadsToUpdate) {
            lead.LeadSource = 'Dreamforce';
        }
        update leadsToUpdate;
    }


}