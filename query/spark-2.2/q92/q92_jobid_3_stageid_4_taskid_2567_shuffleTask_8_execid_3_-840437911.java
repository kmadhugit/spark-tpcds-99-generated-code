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
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     wholestagecodegen_init_0();
/* 045 */     wholestagecodegen_init_1();
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void wholestagecodegen_init_0() {
/* 050 */     scan_input = inputs[0];
/* 051 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 052 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     scan_scanTime1 = 0;
/* 054 */     scan_batch = null;
/* 055 */     scan_batchIdx = 0;
/* 056 */     scan_colInstance0 = null;
/* 057 */     scan_colInstance1 = null;
/* 058 */     scan_colInstance2 = null;
/* 059 */     scan_result = new UnsafeRow(3);
/* 060 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 061 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 062 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 063 */     filter_result = new UnsafeRow(3);
/* 064 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 065 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 066 */     project_result = new UnsafeRow(3);
/* 067 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private void scan_nextBatch() throws java.io.IOException {
/* 072 */     long getBatchStart = System.nanoTime();
/* 073 */     if (scan_input.hasNext()) {
/* 074 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 075 */       scan_numOutputRows.add(scan_batch.numRows());
/* 076 */       scan_batchIdx = 0;
/* 077 */       scan_colInstance0 = scan_batch.column(0);
/* 078 */       scan_colInstance1 = scan_batch.column(1);
/* 079 */       scan_colInstance2 = scan_batch.column(2);
/* 080 */
/* 081 */     }
/* 082 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 083 */   }
/* 084 */
/* 085 */   private void wholestagecodegen_init_1() {
/* 086 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 087 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 088 */
/* 089 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 090 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 091 */
/* 092 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 093 */     bhj_result = new UnsafeRow(4);
/* 094 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 095 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 096 */     project_result1 = new UnsafeRow(3);
/* 097 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 098 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 099 */
/* 100 */   }
/* 101 */
/* 102 */   protected void processNext() throws java.io.IOException {
/* 103 */     if (scan_batch == null) {
/* 104 */       scan_nextBatch();
/* 105 */     }
/* 106 */     while (scan_batch != null) {
/* 107 */       int scan_numRows = scan_batch.numRows();
/* 108 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 109 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 110 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 111 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 112 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 113 */
/* 114 */         if (!(!(scan_isNull))) continue;
/* 115 */
/* 116 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 117 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 118 */
/* 119 */         if (!(!(scan_isNull1))) continue;
/* 120 */
/* 121 */         filter_numOutputRows.add(1);
/* 122 */
/* 123 */         // generate join key for stream side
/* 124 */
/* 125 */         boolean bhj_isNull = false;
/* 126 */         long bhj_value = -1L;
/* 127 */         if (!false) {
/* 128 */           bhj_value = (long) scan_value;
/* 129 */         }
/* 130 */         // find matches from HashedRelation
/* 131 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 132 */         if (bhj_matched == null) continue;
/* 133 */
/* 134 */         bhj_numOutputRows.add(1);
/* 135 */
/* 136 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 137 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 138 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 139 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 140 */         project_rowWriter1.zeroOutNullBytes();
/* 141 */
/* 142 */         project_rowWriter1.write(0, scan_value1);
/* 143 */
/* 144 */         if (scan_isNull2) {
/* 145 */           project_rowWriter1.setNullAt(1);
/* 146 */         } else {
/* 147 */           project_rowWriter1.write(1, scan_value2);
/* 148 */         }
/* 149 */
/* 150 */         if (bhj_isNull2) {
/* 151 */           project_rowWriter1.setNullAt(2);
/* 152 */         } else {
/* 153 */           project_rowWriter1.write(2, bhj_value2);
/* 154 */         }
/* 155 */         append(project_result1);
/* 156 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 157 */       }
/* 158 */       scan_batchIdx = scan_numRows;
/* 159 */       scan_batch = null;
/* 160 */       scan_nextBatch();
/* 161 */     }
/* 162 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 163 */     scan_scanTime1 = 0;
/* 164 */   }
/* 165 */ }
