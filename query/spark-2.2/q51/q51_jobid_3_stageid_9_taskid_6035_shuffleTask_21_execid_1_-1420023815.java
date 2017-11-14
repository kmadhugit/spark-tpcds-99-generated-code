/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private UnsafeRow project_result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 012 */
/* 013 */   public GeneratedIterator(Object[] references) {
/* 014 */     this.references = references;
/* 015 */   }
/* 016 */
/* 017 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 018 */     partitionIndex = index;
/* 019 */     this.inputs = inputs;
/* 020 */     inputadapter_input = inputs[0];
/* 021 */     project_result = new UnsafeRow(4);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 031 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 032 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 033 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 034 */
/* 035 */       boolean project_isNull = true;
/* 036 */       int project_value = -1;
/* 037 */
/* 038 */       if (!false && (!(inputadapter_isNull))) {
/* 039 */         project_isNull = inputadapter_isNull;
/* 040 */         project_value = inputadapter_value;
/* 041 */       }
/* 042 */
/* 043 */       else {
/* 044 */         boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 045 */         int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 046 */         project_isNull = inputadapter_isNull3;
/* 047 */         project_value = inputadapter_value3;
/* 048 */       }
/* 049 */       boolean project_isNull5 = true;
/* 050 */       UTF8String project_value5 = null;
/* 051 */
/* 052 */       if (!false && (!(inputadapter_isNull1))) {
/* 053 */         project_isNull5 = inputadapter_isNull1;
/* 054 */         project_value5 = inputadapter_value1;
/* 055 */       }
/* 056 */
/* 057 */       else {
/* 058 */         boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 059 */         UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 060 */         project_isNull5 = inputadapter_isNull4;
/* 061 */         project_value5 = inputadapter_value4;
/* 062 */       }
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 065 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 066 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 067 */       project_holder.reset();
/* 068 */
/* 069 */       project_rowWriter.zeroOutNullBytes();
/* 070 */
/* 071 */       if (project_isNull) {
/* 072 */         project_rowWriter.setNullAt(0);
/* 073 */       } else {
/* 074 */         project_rowWriter.write(0, project_value);
/* 075 */       }
/* 076 */
/* 077 */       if (project_isNull5) {
/* 078 */         project_rowWriter.setNullAt(1);
/* 079 */       } else {
/* 080 */         project_rowWriter.write(1, project_value5);
/* 081 */       }
/* 082 */
/* 083 */       if (inputadapter_isNull2) {
/* 084 */         project_rowWriter.setNullAt(2);
/* 085 */       } else {
/* 086 */         project_rowWriter.write(2, inputadapter_value2);
/* 087 */       }
/* 088 */
/* 089 */       if (inputadapter_isNull5) {
/* 090 */         project_rowWriter.setNullAt(3);
/* 091 */       } else {
/* 092 */         project_rowWriter.write(3, inputadapter_value5);
/* 093 */       }
/* 094 */       project_result.setTotalSize(project_holder.totalSize());
/* 095 */       append(project_result);
/* 096 */       if (shouldStop()) return;
/* 097 */     }
/* 098 */   }
/* 099 */ }
