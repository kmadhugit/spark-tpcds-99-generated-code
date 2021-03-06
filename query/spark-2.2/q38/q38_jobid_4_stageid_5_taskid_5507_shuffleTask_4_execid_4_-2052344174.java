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
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 020 */   private UnsafeRow filter_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 027 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private UnsafeRow project_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     scan_input = inputs[0];
/* 050 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 051 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     scan_scanTime1 = 0;
/* 053 */     scan_batch = null;
/* 054 */     scan_batchIdx = 0;
/* 055 */     scan_colInstance0 = null;
/* 056 */     scan_colInstance1 = null;
/* 057 */     scan_result = new UnsafeRow(2);
/* 058 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 059 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 060 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 061 */     filter_result = new UnsafeRow(2);
/* 062 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 063 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 064 */     project_result = new UnsafeRow(2);
/* 065 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void scan_nextBatch() throws java.io.IOException {
/* 070 */     long getBatchStart = System.nanoTime();
/* 071 */     if (scan_input.hasNext()) {
/* 072 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 073 */       scan_numOutputRows.add(scan_batch.numRows());
/* 074 */       scan_batchIdx = 0;
/* 075 */       scan_colInstance0 = scan_batch.column(0);
/* 076 */       scan_colInstance1 = scan_batch.column(1);
/* 077 */
/* 078 */     }
/* 079 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_1() {
/* 083 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 084 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 085 */
/* 086 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 087 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 088 */
/* 089 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 090 */     bhj_result = new UnsafeRow(4);
/* 091 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 092 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 093 */     project_result1 = new UnsafeRow(2);
/* 094 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 095 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 096 */
/* 097 */   }
/* 098 */
/* 099 */   protected void processNext() throws java.io.IOException {
/* 100 */     if (scan_batch == null) {
/* 101 */       scan_nextBatch();
/* 102 */     }
/* 103 */     while (scan_batch != null) {
/* 104 */       int scan_numRows = scan_batch.numRows();
/* 105 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 106 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 107 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 108 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 109 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 110 */
/* 111 */         if (!(!(scan_isNull))) continue;
/* 112 */
/* 113 */         filter_numOutputRows.add(1);
/* 114 */
/* 115 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 116 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 117 */
/* 118 */         // generate join key for stream side
/* 119 */
/* 120 */         boolean bhj_isNull = scan_isNull1;
/* 121 */         long bhj_value = -1L;
/* 122 */         if (!scan_isNull1) {
/* 123 */           bhj_value = (long) scan_value1;
/* 124 */         }
/* 125 */         // find matches from HashedRelation
/* 126 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 127 */         if (bhj_matched == null) continue;
/* 128 */
/* 129 */         bhj_numOutputRows.add(1);
/* 130 */
/* 131 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 132 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 133 */         project_holder1.reset();
/* 134 */
/* 135 */         project_rowWriter1.zeroOutNullBytes();
/* 136 */
/* 137 */         project_rowWriter1.write(0, scan_value);
/* 138 */
/* 139 */         if (bhj_isNull3) {
/* 140 */           project_rowWriter1.setNullAt(1);
/* 141 */         } else {
/* 142 */           project_rowWriter1.write(1, bhj_value3);
/* 143 */         }
/* 144 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 145 */         append(project_result1);
/* 146 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 147 */       }
/* 148 */       scan_batchIdx = scan_numRows;
/* 149 */       scan_batch = null;
/* 150 */       scan_nextBatch();
/* 151 */     }
/* 152 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 153 */     scan_scanTime1 = 0;
/* 154 */   }
/* 155 */ }
