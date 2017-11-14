/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */   private UnsafeRow project_result;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 016 */
/* 017 */   public GeneratedIterator(Object[] references) {
/* 018 */     this.references = references;
/* 019 */   }
/* 020 */
/* 021 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 022 */     partitionIndex = index;
/* 023 */     this.inputs = inputs;
/* 024 */     inputadapter_input = inputs[0];
/* 025 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 026 */     filter_result = new UnsafeRow(7);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 029 */     project_result = new UnsafeRow(5);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 039 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 040 */
/* 041 */       if (!(!(inputadapter_isNull6))) continue;
/* 042 */
/* 043 */       filter_numOutputRows.add(1);
/* 044 */
/* 045 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 046 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 047 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 048 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 049 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 050 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 051 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 052 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 053 */       project_holder.reset();
/* 054 */
/* 055 */       project_rowWriter.zeroOutNullBytes();
/* 056 */
/* 057 */       if (inputadapter_isNull) {
/* 058 */         project_rowWriter.setNullAt(0);
/* 059 */       } else {
/* 060 */         project_rowWriter.write(0, inputadapter_value);
/* 061 */       }
/* 062 */
/* 063 */       if (inputadapter_isNull1) {
/* 064 */         project_rowWriter.setNullAt(1);
/* 065 */       } else {
/* 066 */         project_rowWriter.write(1, inputadapter_value1);
/* 067 */       }
/* 068 */
/* 069 */       if (inputadapter_isNull2) {
/* 070 */         project_rowWriter.setNullAt(2);
/* 071 */       } else {
/* 072 */         project_rowWriter.write(2, inputadapter_value2);
/* 073 */       }
/* 074 */
/* 075 */       if (inputadapter_isNull5) {
/* 076 */         project_rowWriter.setNullAt(3);
/* 077 */       } else {
/* 078 */         project_rowWriter.write(3, inputadapter_value5);
/* 079 */       }
/* 080 */
/* 081 */       project_rowWriter.write(4, inputadapter_value6);
/* 082 */       project_result.setTotalSize(project_holder.totalSize());
/* 083 */       append(project_result);
/* 084 */       if (shouldStop()) return;
/* 085 */     }
/* 086 */   }
/* 087 */ }
