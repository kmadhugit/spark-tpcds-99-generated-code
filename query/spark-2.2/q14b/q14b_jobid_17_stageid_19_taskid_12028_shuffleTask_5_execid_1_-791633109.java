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
/* 035 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 036 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 038 */   private UnsafeRow bhj_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 041 */   private UnsafeRow project_result2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     wholestagecodegen_init_0();
/* 053 */     wholestagecodegen_init_1();
/* 054 */     wholestagecodegen_init_2();
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void wholestagecodegen_init_0() {
/* 059 */     scan_input = inputs[0];
/* 060 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 061 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 062 */     scan_scanTime1 = 0;
/* 063 */     scan_batch = null;
/* 064 */     scan_batchIdx = 0;
/* 065 */     scan_colInstance0 = null;
/* 066 */     scan_colInstance1 = null;
/* 067 */     scan_result = new UnsafeRow(2);
/* 068 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 069 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 070 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 071 */     filter_result = new UnsafeRow(2);
/* 072 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 073 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 074 */     project_result = new UnsafeRow(2);
/* 075 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void scan_nextBatch() throws java.io.IOException {
/* 080 */     long getBatchStart = System.nanoTime();
/* 081 */     if (scan_input.hasNext()) {
/* 082 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 083 */       scan_numOutputRows.add(scan_batch.numRows());
/* 084 */       scan_batchIdx = 0;
/* 085 */       scan_colInstance0 = scan_batch.column(0);
/* 086 */       scan_colInstance1 = scan_batch.column(1);
/* 087 */
/* 088 */     }
/* 089 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 090 */   }
/* 091 */
/* 092 */   private void wholestagecodegen_init_2() {
/* 093 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 094 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 095 */
/* 096 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 097 */     bhj_result1 = new UnsafeRow(5);
/* 098 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 099 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 100 */     project_result2 = new UnsafeRow(3);
/* 101 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 102 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   private void wholestagecodegen_init_1() {
/* 107 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 108 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 109 */
/* 110 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 111 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 112 */
/* 113 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 114 */     bhj_result = new UnsafeRow(6);
/* 115 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 116 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 117 */     project_result1 = new UnsafeRow(4);
/* 118 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 119 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 120 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */   protected void processNext() throws java.io.IOException {
/* 125 */     if (scan_batch == null) {
/* 126 */       scan_nextBatch();
/* 127 */     }
/* 128 */     while (scan_batch != null) {
/* 129 */       int scan_numRows = scan_batch.numRows();
/* 130 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 131 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 132 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 133 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 134 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 135 */
/* 136 */         if (!(!(scan_isNull))) continue;
/* 137 */
/* 138 */         filter_numOutputRows.add(1);
/* 139 */
/* 140 */         // generate join key for stream side
/* 141 */
/* 142 */         boolean bhj_isNull = false;
/* 143 */         long bhj_value = -1L;
/* 144 */         if (!false) {
/* 145 */           bhj_value = (long) scan_value;
/* 146 */         }
/* 147 */         // find matches from HashedRelation
/* 148 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 149 */         if (bhj_matched == null) continue;
/* 150 */
/* 151 */         bhj_numOutputRows.add(1);
/* 152 */
/* 153 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 154 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 155 */
/* 156 */         // generate join key for stream side
/* 157 */
/* 158 */         boolean bhj_isNull12 = scan_isNull1;
/* 159 */         long bhj_value12 = -1L;
/* 160 */         if (!scan_isNull1) {
/* 161 */           bhj_value12 = (long) scan_value1;
/* 162 */         }
/* 163 */         // find matches from HashedRelation
/* 164 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 165 */         if (bhj_matched1 == null) continue;
/* 166 */
/* 167 */         bhj_numOutputRows1.add(1);
/* 168 */
/* 169 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 170 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 171 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 172 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 173 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 174 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 175 */         project_rowWriter2.zeroOutNullBytes();
/* 176 */
/* 177 */         if (bhj_isNull3) {
/* 178 */           project_rowWriter2.setNullAt(0);
/* 179 */         } else {
/* 180 */           project_rowWriter2.write(0, bhj_value3);
/* 181 */         }
/* 182 */
/* 183 */         if (bhj_isNull4) {
/* 184 */           project_rowWriter2.setNullAt(1);
/* 185 */         } else {
/* 186 */           project_rowWriter2.write(1, bhj_value4);
/* 187 */         }
/* 188 */
/* 189 */         if (bhj_isNull5) {
/* 190 */           project_rowWriter2.setNullAt(2);
/* 191 */         } else {
/* 192 */           project_rowWriter2.write(2, bhj_value5);
/* 193 */         }
/* 194 */         append(project_result2);
/* 195 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 196 */       }
/* 197 */       scan_batchIdx = scan_numRows;
/* 198 */       scan_batch = null;
/* 199 */       scan_nextBatch();
/* 200 */     }
/* 201 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 202 */     scan_scanTime1 = 0;
/* 203 */   }
/* 204 */ }
