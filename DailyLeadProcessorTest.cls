@IsTest
public class DailyLeadProcessorTest {
    @IsTest
    public static void testDailyLeadProcessor() {
        List<Lead> leadsToInsert = new List<Lead>();
        for (Integer i = 0; i < 200; i++) {
            leadsToInsert.add(new Lead(FirstName = 'Test', LastName = 'Lead', Company = 'Test Company'));
        }
        insert leadsToInsert;
        Test.startTest();
        String schedule = '0 0 0 * * ?'; // run daily at midnight
        DailyLeadProcessor scheduler = new DailyLeadProcessor();
        System.schedule('DailyLeadProcessorTest', schedule, scheduler);
        Test.stopTest();
        List<Lead> updatedLeads = [SELECT Id, LeadSource FROM Lead WHERE LeadSource = 'Dreamforce'];
        System.assertEquals(200, updatedLeads.size(), 'All leads should have been updated');
    }
}