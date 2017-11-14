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
/* 026 */     filter_result = new UnsafeRow(8);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 128);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 029 */     project_result = new UnsafeRow(6);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 039 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 040 */
/* 041 */       if (!(!(inputadapter_isNull7))) continue;
/* 042 */
/* 043 */       filter_numOutputRows.add(1);
/* 044 */
/* 045 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 046 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 047 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 048 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 049 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 050 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 051 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 052 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 053 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 054 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 055 */       project_holder.reset();
/* 056 */
/* 057 */       project_rowWriter.zeroOutNullBytes();
/* 058 */
/* 059 */       if (inputadapter_isNull) {
/* 060 */         project_rowWriter.setNullAt(0);
/* 061 */       } else {
/* 062 */         project_rowWriter.write(0, inputadapter_value);
/* 063 */       }
/* 064 */
/* 065 */       if (inputadapter_isNull1) {
/* 066 */         project_rowWriter.setNullAt(1);
/* 067 */       } else {
/* 068 */         project_rowWriter.write(1, inputadapter_value1);
/* 069 */       }
/* 070 */
/* 071 */       if (inputadapter_isNull2) {
/* 072 */         project_rowWriter.setNullAt(2);
/* 073 */       } else {
/* 074 */         project_rowWriter.write(2, inputadapter_value2);
/* 075 */       }
/* 076 */
/* 077 */       if (inputadapter_isNull3) {
/* 078 */         project_rowWriter.setNullAt(3);
/* 079 */       } else {
/* 080 */         project_rowWriter.write(3, inputadapter_value3);
/* 081 */       }
/* 082 */
/* 083 */       if (inputadapter_isNull6) {
/* 084 */         project_rowWriter.setNullAt(4);
/* 085 */       } else {
/* 086 */         project_rowWriter.write(4, inputadapter_value6);
/* 087 */       }
/* 088 */
/* 089 */       project_rowWriter.write(5, inputadapter_value7);
/* 090 */       project_result.setTotalSize(project_holder.totalSize());
/* 091 */       append(project_result);
/* 092 */       if (shouldStop()) return;
/* 093 */     }
/* 094 */   }
/* 095 */ }
