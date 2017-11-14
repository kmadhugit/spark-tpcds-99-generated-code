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
/* 012 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 013 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 015 */   private UnsafeRow bhj_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 018 */   private UnsafeRow project_result1;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 021 */
/* 022 */   public GeneratedIterator(Object[] references) {
/* 023 */     this.references = references;
/* 024 */   }
/* 025 */
/* 026 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 027 */     partitionIndex = index;
/* 028 */     this.inputs = inputs;
/* 029 */     wholestagecodegen_init_0();
/* 030 */     wholestagecodegen_init_1();
/* 031 */
/* 032 */   }
/* 033 */
/* 034 */   private void wholestagecodegen_init_0() {
/* 035 */     inputadapter_input = inputs[0];
/* 036 */     project_result = new UnsafeRow(3);
/* 037 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 038 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 039 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[0];
/* 040 */
/* 041 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 042 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 043 */
/* 044 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 045 */     bhj_result = new UnsafeRow(4);
/* 046 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 047 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 048 */     project_result1 = new UnsafeRow(1);
/* 049 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void wholestagecodegen_init_1() {
/* 054 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   protected void processNext() throws java.io.IOException {
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull33 = inputadapter_row.isNullAt(33);
/* 062 */       int inputadapter_value33 = inputadapter_isNull33 ? -1 : (inputadapter_row.getInt(33));
/* 063 */
/* 064 */       // generate join key for stream side
/* 065 */
/* 066 */       boolean bhj_isNull = inputadapter_isNull33;
/* 067 */       long bhj_value = -1L;
/* 068 */       if (!inputadapter_isNull33) {
/* 069 */         bhj_value = (long) inputadapter_value33;
/* 070 */       }
/* 071 */       // find matches from HashedRelation
/* 072 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 073 */       if (bhj_matched == null) continue;
/* 074 */
/* 075 */       bhj_numOutputRows.add(1);
/* 076 */
/* 077 */       boolean project_isNull6 = true;
/* 078 */       double project_value6 = -1.0;
/* 079 */
/* 080 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 081 */       int inputadapter_value17 = inputadapter_isNull17 ? -1 : (inputadapter_row.getInt(17));
/* 082 */       boolean project_isNull7 = inputadapter_isNull17;
/* 083 */       double project_value7 = -1.0;
/* 084 */       if (!inputadapter_isNull17) {
/* 085 */         project_value7 = (double) inputadapter_value17;
/* 086 */       }
/* 087 */       if (!project_isNull7) {
/* 088 */         boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 089 */         double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 090 */         if (!inputadapter_isNull19) {
/* 091 */           project_isNull6 = false; // resultCode could change nullability.
/* 092 */           project_value6 = project_value7 * inputadapter_value19;
/* 093 */
/* 094 */         }
/* 095 */
/* 096 */       }
/* 097 */       project_rowWriter1.zeroOutNullBytes();
/* 098 */
/* 099 */       if (project_isNull6) {
/* 100 */         project_rowWriter1.setNullAt(0);
/* 101 */       } else {
/* 102 */         project_rowWriter1.write(0, project_value6);
/* 103 */       }
/* 104 */       append(project_result1);
/* 105 */       if (shouldStop()) return;
/* 106 */     }
/* 107 */   }
/* 108 */ }
