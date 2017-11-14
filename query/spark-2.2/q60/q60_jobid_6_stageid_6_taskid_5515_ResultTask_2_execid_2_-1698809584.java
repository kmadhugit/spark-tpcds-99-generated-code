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
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private UnsafeRow scan_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 040 */   private UnsafeRow filter_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 047 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 052 */   private UnsafeRow bhj_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 055 */   private UnsafeRow project_result1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 058 */
/* 059 */   public GeneratedIterator(Object[] references) {
/* 060 */     this.references = references;
/* 061 */   }
/* 062 */
/* 063 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 064 */     partitionIndex = index;
/* 065 */     this.inputs = inputs;
/* 066 */     wholestagecodegen_init_0();
/* 067 */     wholestagecodegen_init_1();
/* 068 */     wholestagecodegen_init_2();
/* 069 */
/* 070 */   }
/* 071 */
/* 072 */   private void wholestagecodegen_init_0() {
/* 073 */     scan_input = inputs[0];
/* 074 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 075 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 076 */     scan_scanTime1 = 0;
/* 077 */     scan_batch = null;
/* 078 */     scan_batchIdx = 0;
/* 079 */     scan_colInstance0 = null;
/* 080 */     scan_colInstance1 = null;
/* 081 */     scan_colInstance2 = null;
/* 082 */     scan_colInstance3 = null;
/* 083 */     scan_colInstance4 = null;
/* 084 */     scan_colInstance5 = null;
/* 085 */     scan_colInstance6 = null;
/* 086 */     scan_colInstance7 = null;
/* 087 */     scan_colInstance8 = null;
/* 088 */     scan_colInstance9 = null;
/* 089 */     scan_colInstance10 = null;
/* 090 */     scan_colInstance11 = null;
/* 091 */     scan_colInstance12 = null;
/* 092 */     scan_colInstance13 = null;
/* 093 */     scan_colInstance14 = null;
/* 094 */     scan_colInstance15 = null;
/* 095 */     scan_colInstance16 = null;
/* 096 */     scan_colInstance17 = null;
/* 097 */     scan_colInstance18 = null;
/* 098 */     scan_colInstance19 = null;
/* 099 */     scan_colInstance20 = null;
/* 100 */     scan_colInstance21 = null;
/* 101 */     scan_result = new UnsafeRow(22);
/* 102 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 448);
/* 103 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 22);
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void scan_nextBatch() throws java.io.IOException {
/* 108 */     long getBatchStart = System.nanoTime();
/* 109 */     if (scan_input.hasNext()) {
/* 110 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 111 */       scan_numOutputRows.add(scan_batch.numRows());
/* 112 */       scan_batchIdx = 0;
/* 113 */       scan_colInstance0 = scan_batch.column(0);
/* 114 */       scan_colInstance1 = scan_batch.column(1);
/* 115 */       scan_colInstance2 = scan_batch.column(2);
/* 116 */       scan_colInstance3 = scan_batch.column(3);
/* 117 */       scan_colInstance4 = scan_batch.column(4);
/* 118 */       scan_colInstance5 = scan_batch.column(5);
/* 119 */       scan_colInstance6 = scan_batch.column(6);
/* 120 */       scan_colInstance7 = scan_batch.column(7);
/* 121 */       scan_colInstance8 = scan_batch.column(8);
/* 122 */       scan_colInstance9 = scan_batch.column(9);
/* 123 */       scan_colInstance10 = scan_batch.column(10);
/* 124 */       scan_colInstance11 = scan_batch.column(11);
/* 125 */       scan_colInstance12 = scan_batch.column(12);
/* 126 */       scan_colInstance13 = scan_batch.column(13);
/* 127 */       scan_colInstance14 = scan_batch.column(14);
/* 128 */       scan_colInstance15 = scan_batch.column(15);
/* 129 */       scan_colInstance16 = scan_batch.column(16);
/* 130 */       scan_colInstance17 = scan_batch.column(17);
/* 131 */       scan_colInstance18 = scan_batch.column(18);
/* 132 */       scan_colInstance19 = scan_batch.column(19);
/* 133 */       scan_colInstance20 = scan_batch.column(20);
/* 134 */       scan_colInstance21 = scan_batch.column(21);
/* 135 */
/* 136 */     }
/* 137 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 138 */   }
/* 139 */
/* 140 */   private void wholestagecodegen_init_2() {
/* 141 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 142 */     bhj_result1 = new UnsafeRow(22);
/* 143 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 448);
/* 144 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 22);
/* 145 */     project_result1 = new UnsafeRow(2);
/* 146 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 147 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   private void wholestagecodegen_init_1() {
/* 152 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 153 */     filter_result = new UnsafeRow(22);
/* 154 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 448);
/* 155 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 22);
/* 156 */     project_result = new UnsafeRow(22);
/* 157 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 448);
/* 158 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 22);
/* 159 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 160 */
/* 161 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 162 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 163 */
/* 164 */     bhj_result = new UnsafeRow(1);
/* 165 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 166 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 1);
/* 167 */
/* 168 */   }
/* 169 */
/* 170 */   protected void processNext() throws java.io.IOException {
/* 171 */     if (scan_batch == null) {
/* 172 */       scan_nextBatch();
/* 173 */     }
/* 174 */     while (scan_batch != null) {
/* 175 */       int scan_numRows = scan_batch.numRows();
/* 176 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 177 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 178 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 179 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 180 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 181 */
/* 182 */         if (!(!(scan_isNull))) continue;
/* 183 */
/* 184 */         filter_numOutputRows.add(1);
/* 185 */
/* 186 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 187 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 188 */
/* 189 */         // generate join key for stream side
/* 190 */
/* 191 */         bhj_holder.reset();
/* 192 */
/* 193 */         bhj_rowWriter.zeroOutNullBytes();
/* 194 */
/* 195 */         if (scan_isNull1) {
/* 196 */           bhj_rowWriter.setNullAt(0);
/* 197 */         } else {
/* 198 */           bhj_rowWriter.write(0, scan_value1);
/* 199 */         }
/* 200 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 201 */
/* 202 */         // find matches from HashRelation
/* 203 */         scala.collection.Iterator bhj_matches = bhj_result.anyNull() ? null : (scala.collection.Iterator)bhj_relation.get(bhj_result);
/* 204 */         if (bhj_matches == null) continue;
/* 205 */         boolean bhj_found = false;
/* 206 */         while (!bhj_found && bhj_matches.hasNext()) {
/* 207 */           UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 208 */
/* 209 */           bhj_found = true;
/* 210 */         }
/* 211 */         if (!bhj_found) continue;
/* 212 */         bhj_numOutputRows.add(1);
/* 213 */
/* 214 */         project_holder1.reset();
/* 215 */
/* 216 */         project_rowWriter1.zeroOutNullBytes();
/* 217 */
/* 218 */         project_rowWriter1.write(0, scan_value);
/* 219 */
/* 220 */         if (scan_isNull1) {
/* 221 */           project_rowWriter1.setNullAt(1);
/* 222 */         } else {
/* 223 */           project_rowWriter1.write(1, scan_value1);
/* 224 */         }
/* 225 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 226 */         append(project_result1);
/* 227 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 228 */       }
/* 229 */       scan_batchIdx = scan_numRows;
/* 230 */       scan_batch = null;
/* 231 */       scan_nextBatch();
/* 232 */     }
/* 233 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 234 */     scan_scanTime1 = 0;
/* 235 */   }
/* 236 */ }
