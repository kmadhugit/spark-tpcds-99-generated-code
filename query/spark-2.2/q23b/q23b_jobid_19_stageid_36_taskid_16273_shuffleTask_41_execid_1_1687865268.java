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
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 031 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 032 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 033 */       int inputadapter_value17 = inputadapter_isNull17 ? -1 : (inputadapter_row.getInt(17));
/* 034 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 035 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 036 */       boolean inputadapter_isNull33 = inputadapter_row.isNullAt(33);
/* 037 */       int inputadapter_value33 = inputadapter_isNull33 ? -1 : (inputadapter_row.getInt(33));
/* 038 */       project_rowWriter.zeroOutNullBytes();
/* 039 */
/* 040 */       if (inputadapter_isNull3) {
/* 041 */         project_rowWriter.setNullAt(0);
/* 042 */       } else {
/* 043 */         project_rowWriter.write(0, inputadapter_value3);
/* 044 */       }
/* 045 */
/* 046 */       if (inputadapter_isNull17) {
/* 047 */         project_rowWriter.setNullAt(1);
/* 048 */       } else {
/* 049 */         project_rowWriter.write(1, inputadapter_value17);
/* 050 */       }
/* 051 */
/* 052 */       if (inputadapter_isNull19) {
/* 053 */         project_rowWriter.setNullAt(2);
/* 054 */       } else {
/* 055 */         project_rowWriter.write(2, inputadapter_value19);
/* 056 */       }
/* 057 */
/* 058 */       if (inputadapter_isNull33) {
/* 059 */         project_rowWriter.setNullAt(3);
/* 060 */       } else {
/* 061 */         project_rowWriter.write(3, inputadapter_value33);
/* 062 */       }
/* 063 */       append(project_result);
/* 064 */       if (shouldStop()) return;
/* 065 */     }
/* 066 */   }
/* 067 */ }
