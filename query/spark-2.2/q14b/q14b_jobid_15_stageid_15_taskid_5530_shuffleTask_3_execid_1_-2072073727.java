/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 021 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 023 */   private UnsafeRow bhj_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_result = new UnsafeRow(3);
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 055 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[2];
/* 056 */
/* 057 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 058 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 059 */
/* 060 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 061 */     bhj_result = new UnsafeRow(4);
/* 062 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void scan_nextBatch() throws java.io.IOException {
/* 067 */     long getBatchStart = System.nanoTime();
/* 068 */     if (scan_input.hasNext()) {
/* 069 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 070 */       scan_numOutputRows.add(scan_batch.numRows());
/* 071 */       scan_batchIdx = 0;
/* 072 */       scan_colInstance0 = scan_batch.column(0);
/* 073 */       scan_colInstance1 = scan_batch.column(1);
/* 074 */       scan_colInstance2 = scan_batch.column(2);
/* 075 */
/* 076 */     }
/* 077 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 078 */   }
/* 079 */
/* 080 */   private void wholestagecodegen_init_1() {
/* 081 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 082 */     project_result = new UnsafeRow(2);
/* 083 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 084 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   protected void processNext() throws java.io.IOException {
/* 089 */     if (scan_batch == null) {
/* 090 */       scan_nextBatch();
/* 091 */     }
/* 092 */     while (scan_batch != null) {
/* 093 */       int scan_numRows = scan_batch.numRows();
/* 094 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 095 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 096 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 097 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 098 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 099 */
/* 100 */         // generate join key for stream side
/* 101 */
/* 102 */         boolean bhj_isNull = scan_isNull2;
/* 103 */         long bhj_value = -1L;
/* 104 */         if (!scan_isNull2) {
/* 105 */           bhj_value = (long) scan_value2;
/* 106 */         }
/* 107 */         // find matches from HashedRelation
/* 108 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 109 */         if (bhj_matched == null) continue;
/* 110 */
/* 111 */         bhj_numOutputRows.add(1);
/* 112 */
/* 113 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 114 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 115 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 116 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 117 */         project_rowWriter.zeroOutNullBytes();
/* 118 */
/* 119 */         if (scan_isNull) {
/* 120 */           project_rowWriter.setNullAt(0);
/* 121 */         } else {
/* 122 */           project_rowWriter.write(0, scan_value);
/* 123 */         }
/* 124 */
/* 125 */         if (scan_isNull1) {
/* 126 */           project_rowWriter.setNullAt(1);
/* 127 */         } else {
/* 128 */           project_rowWriter.write(1, scan_value1);
/* 129 */         }
/* 130 */         append(project_result);
/* 131 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 132 */       }
/* 133 */       scan_batchIdx = scan_numRows;
/* 134 */       scan_batch = null;
/* 135 */       scan_nextBatch();
/* 136 */     }
/* 137 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 138 */     scan_scanTime1 = 0;
/* 139 */   }
/* 140 */ }
